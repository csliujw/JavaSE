package thread._11_error;

public class JavapDemo {
    static Integer lock = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (lock) {
                    lock++;
                }
            }
        });
        thread.start();
    }
}
