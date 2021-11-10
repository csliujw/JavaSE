package monitor;

import java.util.ArrayList;

/**
 * 测试线程安全问题
 */
public class TestThreadSafe {
    /**
     * Index 0 out of bounds for length 0.
     * add 了两次相同的位置，然后remove了两次，造成的索引越界
     */
    public static void main(String[] args) {
        String d = "12313";
        TestSafe testSafe = new TestSafe();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                testSafe.method1();
            }).start();
        }
    }
}

class TestSafe {
    static int LOOP = 200;

    private ArrayList<String> list = new ArrayList<>();

    public void method1() {
        for (int i = 0; i < LOOP; i++) {
            add();
            remove();
        }
    }

    public void add() {
        list.add("1");
    }

    public void remove() {
        list.remove(0);
    }
}
