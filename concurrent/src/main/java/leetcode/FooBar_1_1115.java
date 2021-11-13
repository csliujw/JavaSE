package leetcode;

public class FooBar_1_1115 {
    /**
     * 两个线程通信的问题。交替执行，要确保 foo 先执行。
     * sync + flag 判断谁先执行
     */
    static class FooBar {
        private int n;
        boolean flag = true;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                synchronized (this) {
                    if (!flag) {
                        this.wait();
                    }
                    printFoo.run();
                    flag = !flag;
                    this.notify();
                }

            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (this) {
                    if (flag) {
                        this.wait();
                    }
                    printBar.run();
                    flag = !flag;
                    this.notify();
                }

            }
        }
    }
}
