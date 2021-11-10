package thread._00_create_thread;

public class CreateByThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        CreateByThread createByThread = new CreateByThread();
        // 让线程执行createByThread对象中的run方法
        Thread thread = new Thread(createByThread);
        // 源码注释：It is never legal to start a thread more than once；start方法只能调用一次
        thread.start();
    }
}
