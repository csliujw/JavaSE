package thread._01_volatile;

import java.util.ArrayList;

public class TestVolatile3 {
    // 听过一个说法，高版本jdk，DCL无需加volatile
    private static volatile TestVolatile3 instance = null;

    private TestVolatile3() {
        System.out.println(Thread.currentThread().getName() + "\t 构造方法被初始化了~");
    }

    // 单例模式 加synchronized就好了
    public static synchronized TestVolatile3 getInstance() {
        if (instance == null) {
            instance = new TestVolatile3();
        }
        return instance;
    }

    public static TestVolatile3 getInstance2() {
        // DCL
        if (instance == null) {
            synchronized (TestVolatile3.class) {
                if (instance == null) {
                    instance = new TestVolatile3();
                }
            }
        }
        return instance;
    }

    // 单线程下是安全的。
    public static void testInstance() {
        System.out.println(TestVolatile3.getInstance() == TestVolatile3.getInstance());
        System.out.println(TestVolatile3.getInstance() == TestVolatile3.getInstance());
        System.out.println(TestVolatile3.getInstance() == TestVolatile3.getInstance());
        System.out.println(TestVolatile3.getInstance() == TestVolatile3.getInstance());
        System.out.println(TestVolatile3.getInstance() == TestVolatile3.getInstance());
    }

    // 多线程下不安全，构造函数会被多次初始化
    public static void testThread() {
        ArrayList<Thread> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Thread(() -> {
                TestVolatile3.getInstance();
            }));
        }
        for (Thread thread : list) {
            thread.start();
        }
    }

    public static void main(String[] args) {
        testThread();
    }


}
