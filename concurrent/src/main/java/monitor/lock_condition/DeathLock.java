package monitor.lock_condition;

import lombok.extern.slf4j.Slf4j;
import monitor.Sleeper;

@Slf4j(topic = "c.DeathLock")
public class DeathLock {
    public static void main(String[] args) {
        Object lockA = new Object();
        Object lockB = new Object();
        Thread th1 = new Thread(() -> {
            synchronized (lockA){
                log.debug("拿到了 lockA");
                Sleeper.sleep(2);
                synchronized (lockB){
                    log.debug("拿到了 lockA --> lockB");
                }
            }
        });

        Thread th2 = new Thread(() -> {
            synchronized (lockB){
                log.debug("拿到了 lockB");
                Sleeper.sleep(1);
                synchronized (lockA){
                    log.debug("拿到了 lockA --> lockB");
                }
            }
        });

        th1.start();
        th2.start();
    }
}
