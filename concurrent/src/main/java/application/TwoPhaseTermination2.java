package application;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 两阶段终止模式。日志监控 Demo
 */
@Slf4j(topic = "c.TwoPhaseTermination")
public class TwoPhaseTermination2 {
    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination2 twoPhaseTermination = new TwoPhaseTermination2();
        twoPhaseTermination.start();
        TimeUnit.SECONDS.sleep(10);
        twoPhaseTermination.stop();
    }

    private volatile boolean stop = false;

    public void stop() {
        stop = true;
    }

    public void start() {
        new Thread(() -> {
            log.debug("start logging~~");
            Thread current = Thread.currentThread();
            while (true) {
                if (stop) {
                    log.debug("over！");
                    return;
                }
                try {
                    TimeUnit.SECONDS.sleep(2);
                    log.debug("start logging~~");
                } catch (InterruptedException e) {
                    // 睡眠过程中被打断。会走 exception。然后将打断标记置为  true。打断完一次 sleep 后再打断就是打断正常线程了。
                    current.interrupt();
                    log.debug("料理后事");
                    e.printStackTrace();
                }
            }
        }).start();
    }
}