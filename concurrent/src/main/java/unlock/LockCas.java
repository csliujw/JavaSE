package unlock;

import lombok.extern.slf4j.Slf4j;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j(topic = "c.LockCas")
public class LockCas {
    private static AtomicInteger state = new AtomicInteger(0);

    public void lock() {
        while (true) {
            if (state.compareAndSet(0, 1)) {
                break;
            }
        }
    }

    public void unlock() {
        log.debug("unlock...");
        state.set(0);
    }

    public static void main(String[] args) {
        LockCas lockCas = new LockCas();
        Thread th = new Thread(() -> {
            try {
                log.debug("begin...");
                lockCas.lock();
                log.debug("lock");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lockCas.unlock();
            }
        }, "线程1");

        Thread th2 = new Thread(() -> {
            try {
                log.debug("begin...");
                lockCas.lock();
                log.debug("lock...");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lockCas.unlock();
            }
        });
        th.start();
        th2.start();
    }
}
