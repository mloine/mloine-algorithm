package con.mloine.threadTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Mloine
 * @Description InheritableThreadLocal测试例子
 * @Date 16:50 2023/2/6
 **/
public class InteritableTest2 {
    static ThreadLocal<String> local = new InheritableThreadLocal<>();
    //static ThreadLocal<String> local = new ThreadLocal<>();
    // 初始化一个长度为1 的线程池
    static ExecutorService poolExecutor = Executors.newFixedThreadPool(1);

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        InteritableTest2 test = new InteritableTest2();
        test.test();
    }

    private void test() {
        // 设置一个初始值
        local.set("天王老子");
        poolExecutor.submit(new Task());

    }

    static class Task implements Runnable {

        @Override
        public void run() {
            // 子线程里面打印获取到的值
            System.out.println(Thread.currentThread().getName() + ":" + local.get());
        }
    }

}
