package application;

import lombok.extern.slf4j.Slf4j;

/**
 * 线程 1 输出 a 5 次，线程 2 输出 b 5 次，线程 3 输出 c 5 次。现在要求输出 abcabcabcabcabc
 * wait notify 版本
 */
@Slf4j(topic = "c.AlternateDemo")
public class AlternateDemo {
    static Object lock = new Object();

    public static void main(String[] args) {
        new PrintThread(lock).start();
        new PrintThread(lock).start();
        new PrintThread(lock).start();
    }
}

class PrintThread extends Thread {
    private Object lock;
    private static int flag = 0;

    public PrintThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (lock) {
                if (flag == 0) {
                    System.out.print("a");
                } else if (flag == 1) {
                    System.out.print("b");
                } else if (flag == 2) {
                    System.out.print("c");
                }
                flag = (flag + 1) % 3;
            }
        }
    }
}