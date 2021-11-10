package monitor;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.MultiLock")
public class MultiLock {
    public static void main(String[] args) {
        MultiLock multiLock = new MultiLock();
        Thread th1 = new Thread(() -> {
            multiLock.study();
        });
        Thread th2 = new Thread(() -> {
            multiLock.sleep();
        });
        th1.start();
        th2.start();
    }

    private final Object studyRoom = new Object();
    private final Object bedRoom = new Object();

    public static void sleeper(int timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sleep() {
        synchronized (bedRoom) {
            log.debug("sleeping 2 小时");
            sleeper(10);
        }
    }

    public void study() {
        synchronized (studyRoom) {
            log.debug("study 1 小时");
            sleeper(5);
        }
    }
}
