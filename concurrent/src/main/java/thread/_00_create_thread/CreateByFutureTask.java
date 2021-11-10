package thread._00_create_thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class CreateByFutureTask {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        MyCallable myCallable = new MyCallable();
        FutureTask futureTask = new FutureTask(myCallable);
        Thread thread = new Thread(futureTask);
        thread.start();
        // get拿到执行完成后的数据，拿不到会在此处阻塞。我看源码用的是yeild,到底是什么原理，后面再补充。
        System.out.println(futureTask.get());
        // 前面的sout语句无法执行，后面的也无法执行，因为都是同一个main线程中执行！！
        System.out.println(123);
    }
}

// 对比Runnable而已，增加了返回值功能。
class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Integer count = 0;
        for (int i = 0; i < 20; i++) {
            TimeUnit.SECONDS.sleep(1);
            count = (count + i) % Integer.MAX_VALUE;
        }
        return count;
    }
}
