package thread._11_error;

/**
 * 错误的加锁
 */
public class SynchronizedError {
    static Integer lock = 0;

    /**
     * 在Java中，Integer属于不变对象，即对象一旦被创建，就不可能被修改。<br>
     * 也就是说，如果你有一个Integer对象代表1，那么它就永远表示1，<br>
     * 你不可能修改Integer对象的值，使它为2。那如果你需要2怎么办呢？<br>
     * 也很简单，新建一个Integer对象，并让它表示2即可<br>
     * 使用javap命令反编译这段代码的run()方法，我们可以看到：<br>
     *
     * @throws InterruptedException
     */
    public static void testInteger() throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (lock) {
                    // lock++的本质是创建一个新的Integer对象，并将它的引用赋值给i
                    // 由于在多个线程间，并不一定能够看到同一个i对象（因为i对象一直在变），
                    // 因此，两个线程每次加锁可能都加在了不同的对象实例上，从而导致对临界区代码控制出现问题。
                    lock++;
                }
            }
        });
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (lock) {
                    lock++;
                }
            }
        });
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println(lock);
    }


    public static void testIntegerModify() throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                // 锁字节码对象就没事，字节码对象一般唯一。
                synchronized (lock.getClass()) {
                    lock++;
                }
            }
        });
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (lock.getClass()) {
                    lock++;
                }
            }
        });
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println(lock);
    }

    public static void main(String[] args) throws InterruptedException {
        testInteger();
    }
}
