package thread._01_volatile;

import java.util.concurrent.TimeUnit;

/**
 * 测试volatile的可见性
 */
public class TestVolatile {

    public static void main(String[] args) {
        ResourceClass resourceClass = new ResourceClass();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                resourceClass.addToSix();
                System.out.println("resourceClass.number=" + resourceClass.number);
            } catch (Exception e) {
            }
        }).start();
        // 如果resourceClass.number==60 则说明数据被刷回了主内存，且被main线程感知到了。
        while (resourceClass.number == 0) ;
        // 如果没有执行最后的这句sout 说明number的值没有被刷新回主内存，更新的值main线程未感知到。
        System.out.println("main thread is over");
    }
}

class ResourceClass {

    // 加了volatile保证了可见性。
    volatile int number = 0;

    public void addToSix() {
        number = 60;
    }
}
