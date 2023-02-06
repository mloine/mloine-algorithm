package con.mloine.threadTest;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Mloine
 * @Description 线程池的创建方式
 * corePoolSize – the number of threads to keep in the pool, even if they are idle, unless allowCoreThreadTimeOut is set
 * maximumPoolSize – the maximum number of threads to allow in the pool
 * keepAliveTime – when the number of threads is greater than the core, this is the maximum time that excess idle threads will wait for new tasks before terminating.
 * unit – the time unit for the keepAliveTime argument
 * workQueue – the queue to use for holding tasks before they are executed. This queue will hold only the Runnable tasks submitted by the execute method.
 * threadFactory – the factory to use when the executor creates a new thread
 * handler – the handler to use when execution is blocked because the thread bounds and queue capacities are reached
 * @Date 23:14 2023/2/6
 **/
public class ThreadPoolTest {

    /**
     * @param args 命令行参数
     */
    public static void main(String[] args) {

        System.out.println("""
                1.CPU密集型
                   System.out.println(Runtime.getRuntime().availableProcessors());
                      获得cpu的核数，不同的硬件不一样
                2.IO密集型
                   大型的程序任务有多少个？ IO非常消耗资源
                   线程池最大值 > 大型任务的数量即可
                   一般设置大型任务的数量*2
                                
                参数
                ● corePoolSize 核心线程数大小
                ● maximumPoolSize 线程池最大线程数量
                ● keepAliveTime 空闲线程的存活时间
                ● unit 空闲线程存活的时间单位
                ● workQueue 工作队列
                  ○ ArrayBlockingQueue 基于数组的有界阻塞队列，按FIFO排序，任务进来后线程数量达到corePoolSize时 会进入队列 , 队列满时 会新增线程数量只到maximumPoolSize大小，超过maximumPoolSize大小则会执行拒绝策略
                  ○ LinkedBlockingQuene 基于链表的无界阻塞队列（其实最大容量为Interger.MAX），按照FIFO排序 。任务进来后线程数大于corePoolSize时 会进入队列。 由于队列不限大小 任务几乎不会被丢弃，maximumPoolSize这个参数此时时无效的
                  ○ SynchronousQuene 一个不缓存任务的阻塞队列 任务进来后会不会被缓存执行， 线程数量超过maximumPoolSize 则会执行拒绝策略
                  ○ PriorityBlockingQueue 具有优先级的无界阻塞队列， 优先级通过参数Comparator实现。
                ● threadFactory 线程工厂
                ● handler 拒绝策略
                  ○ CallerRunsPolicy 调用者线程执行被拒绝的任务
                  ○ AbortPolicy 直接丢弃任务并抛出异常RejectedExecutionException异常。
                  ○ DiscardPolicy 直接丢弃任务
                  ○ DiscardOldestPolicy 抛弃进入队列的最早任务 并尝试插入队列排队
                """);
        System.out.println("当前运行环境运行核数:\t" + Runtime.getRuntime().availableProcessors());

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                24,
                32,
                5,
                TimeUnit.MINUTES,
                new LinkedBlockingDeque<>(),
                //new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()
        );


        // 测试例子
        AtomicInteger finishRunJobCount = new AtomicInteger(0);
        int jobCount = 100;
        CountDownLatch countDownLatch = new CountDownLatch(jobCount);
        long start = System.currentTimeMillis();

        for (int i = 0; i < jobCount; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.printf(String.format("%s:doing%n", Thread.currentThread()));
                finishRunJobCount.addAndGet(1);
                countDownLatch.countDown();
            });
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (threadPoolExecutor.getActiveCount() > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("%s:执行结束 实际完成任务数量%d 整体执行大致耗时%d s%n"
                , Thread.currentThread()
                , finishRunJobCount.get()
                , (System.currentTimeMillis() - start) / 1000);
        System.exit(0);
    }
}
