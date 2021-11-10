package thread._00_create_thread;

/**
 * 新建线程
 */
public class CreateByThread02 {
    public static void main(String[] args) throws InterruptedException {
        // 实例化资源类
        Resource resource = new Resource();
        MyThread myThread = new MyThread(resource);
        Thread thread = new Thread(myThread);
        thread.start();
        thread.join();
        System.out.println(resource.getCount());

    }
}


class MyThread extends Thread {
    private Resource resource;

    public MyThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            resource.increase();
        }
    }
}