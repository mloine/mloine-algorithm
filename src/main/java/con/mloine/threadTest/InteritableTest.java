package con.mloine.threadTest;

import java.util.ServiceLoader;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author Mloine
 * @Description 线程池异常情况下的 InheritableThreadLocal 表现
 * InheritableThreadLocal 只能针对 new Thread()这种方式建立的线程,对于线程池创建的线程,线程是池化以后反复使用的,这个时候父子线程间的值传递已经没有意义了。
 * TransmittableThreadLocal 阿里开源的
 * @Date 16:56 2023/2/6
 **/
public class InteritableTest {

    static ThreadLocal<String> local = new InheritableThreadLocal<>();

    static ExecutorService poolExecutor = Executors.newFixedThreadPool(1);

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        InteritableTest test = new InteritableTest();
        test.test();

        //ServiceLoader<Service> services = ServiceLoader.load(Service.class);
    }

    private void test() throws ExecutionException, InterruptedException {


        local.set("天王老子");
        Future future = poolExecutor.submit(new Task("任务1"));

        future.get();

        Future future2 = poolExecutor.submit(new Task("任务2"));

        future2.get();

        System.out.println("父线程的值：" + local.get());
    }

    static class Task implements Runnable {

        String str;

        Task(String str) {
            this.str = str;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ":" + local.get());
            local.set(str);
            System.out.println(local.get());
        }
    }
}
