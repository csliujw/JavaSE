package monitor;

public class Demo {
    static int count = 0;

    public static void main(String[] args) {
        Object lock = new Object();
        synchronized (lock) {
            count++;
        }
    }
}
