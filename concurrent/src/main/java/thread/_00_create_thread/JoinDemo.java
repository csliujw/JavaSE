package thread._00_create_thread;

import java.util.concurrent.TimeUnit;

public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("========================");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        th1.start();
        // 主线程Main 愿意等th1执行完6秒后再执行。
        th1.join(6000);
        System.out.println("Over!");
    }
}
