package create_thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.CreateByFutureTask")
public class CreateByFutureTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<String>(() -> {
            TimeUnit.SECONDS.sleep(50);
            return "Hello";
        });
        Thread th1 = new Thread(task);
        th1.start();
        // 任务完成前，会阻塞。
        String retVal = task.get();
        log.debug(retVal);
        log.debug("main over!");
        th1.join();
    }
}
