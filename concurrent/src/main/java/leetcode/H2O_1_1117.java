package leetcode;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class H2O_1_1117 {
    static class H2O {
        // 有两个 H 才能产生 O
        public H2O() {

        }

        Semaphore H = new Semaphore(2);
        Semaphore O = new Semaphore(0);

        // 两个 H 一个 O
        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            H.acquire();
            releaseHydrogen.run();
            O.release();
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            O.acquire(2);
            releaseOxygen.run();
            H.release(2);
        }
    }
}
