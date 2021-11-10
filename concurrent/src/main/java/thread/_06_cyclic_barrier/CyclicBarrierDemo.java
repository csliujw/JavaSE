package thread._06_cyclic_barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * 集齐七颗龙珠，召唤神龙。然后释放龙珠，让龙珠做自己的事。
 */
public class CyclicBarrierDemo {
    public static void printFor(int count) {
        for (int i = 0; i < count; i++) {
//            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("神龙出现！");
        });
        for (int i = 0; i < 7; i++) {
            new Thread(() -> {
                try {
                    printFor(10);
                    cyclicBarrier.await();
                    TimeUnit.SECONDS.sleep(20);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
