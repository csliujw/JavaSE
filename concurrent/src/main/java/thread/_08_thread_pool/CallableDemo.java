package thread._08_thread_pool;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class CallableDemo {
    class MyThread implements Callable<Boolean> {
        @Override
        public Boolean call() throws Exception {
            TimeUnit.SECONDS.sleep(5);
            System.out.println("com in Callable");
            TimeUnit.SECONDS.sleep(5);
            return true;

        }
    }

    // 使用Callable
    public static void test1() throws ExecutionException, InterruptedException {
        MyThread myThread = new CallableDemo().new MyThread();
        FutureTask<Boolean> task = new FutureTask<>(myThread);
        new Thread(task, "task1").start();
        //  要求获得Callable线程的计算结果，如果没有计算完成就要去强求，会导致阻塞，直到计算完成
        // 也就是说 futureTask.get() 需要放在最后执行，这样不会导致主线程阻塞
        //也可以使用下面算法，使用类似于自旋锁的方式来进行判断是否运行完毕
        while (!task.isDone()) ; // 未完成就空转，直到完成。
        System.out.println("ok!");
        System.out.println(task.get());
    }

    // 多个线程执行 一个FutureTask的时候，只会计算一次
    // 如果我们要两个线程同时计算任务的话，那么需要这样写，需要定义两个futureTask
    public static void test2() {
        FutureTask<Boolean> futureTask = new FutureTask<>(new CallableDemo().new MyThread());
        FutureTask<Boolean> futureTask2 = new FutureTask<>(new CallableDemo().new MyThread());
        // 开启两个线程计算futureTask
        new Thread(futureTask, "AAA").start();
        new Thread(futureTask2, "BBB").start();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test2();
    }

}
