package monitor;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

@Slf4j(topic = "c.LockSupportDemo")
public class LockSupportDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("开始运行了");
            LockSupport.park();
            log.debug("又运行了~~");
        });
        Thread th2 = new Thread(() -> {
            log.debug("别怕，我来救你！");
            LockSupport.unpark(th1);
        });

        th1.start();
        TimeUnit.SECONDS.sleep(1);
        th2.start();
    }
}
