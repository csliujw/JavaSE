package leetcode;

import java.util.concurrent.*;

public class FooBar_4_1115 {
    /**
     * 两个线程通信的问题。交替执行，要确保 foo 先执行。
     * 阻塞队列 SynchronousQueue 控制执行顺序
     * - SynchronousQueue 只能放一个元素，不拿走再放的话会阻塞住。
     */
    static class FooBar {
        private int n;

        SynchronousQueue<String> str = new SynchronousQueue<String>();

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                str.put("1");
                printFoo.run();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                str.take();
                printBar.run();
            }
        }
    }
}