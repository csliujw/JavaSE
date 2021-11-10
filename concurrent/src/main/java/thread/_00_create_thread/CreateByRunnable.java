package thread._00_create_thread;

public class CreateByRunnable {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
        RunnableDemo runnableDemo = new RunnableDemo(resource);
        Thread thread = new Thread(runnableDemo);
        thread.start();
        thread.join();
        System.out.println(resource.getCount());
    }
}

class RunnableDemo implements Runnable {
    private Resource resource;

    public RunnableDemo(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            resource.increase();
        }
    }
}
