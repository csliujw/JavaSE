package tij.chapter12;

class Go {
    public static void go() {
        System.out.println("方法引用");
    }
}

public class RunnableMethodReference {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类");
            }
        }).start();

        new Thread(() -> System.out.println("lambda表达式")).start();

        new Thread(Go::go).start();
    }
}
