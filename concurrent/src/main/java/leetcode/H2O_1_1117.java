package leetcode;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class H2O_1_1117 {
    static class H2O {
        // 有两个 H 才能产生 O
        public H2O() {

        }

        // 两个 H 一个 O
        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            releaseHydrogen.run();
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            releaseOxygen.run();
        }
    }
}
