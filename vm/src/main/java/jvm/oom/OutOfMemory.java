package jvm.oom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class OutOfMemory {
    // 设置堆空间大小 idea 是设置Vm options -Xms10m -Xmx10m
    public static void testHeapSpace() {
        byte[] bytes = new byte[80 * 1034 * 1024];
    }

    // idea 是设置vm options -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
    public static void testGcOverHeadLimitExceeded() {
        int i = 0;
        ArrayList<String> list = new ArrayList<>();
        try {
            while (true)
                list.add(String.valueOf(i).intern());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {

        }
    }

    // idea 是设置vm options -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
    public static void testDirectMemory() {
        // 堆外内存只设置了5m，但是却申请了6m
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6 * 1024 * 1024);
    }

    public static void testOverThread() {
        for (int i = 0; ; i++) {
            System.out.println("************** i = " + i);
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }

//    public static void metaSpace() {
//        // 模拟计数多少次以后发生异常
//        int i = 0;
//        try {
//            while (true) {
//                i++;
//                // 使用Spring的动态字节码技术
//                Enhancer enhancer = new Enhancer();
//                enhancer.setSuperclass(OOMTest.class);
//                enhancer.setUseCache(false);
//                enhancer.setCallback(new MethodInterceptor() {
//                    @Override
//                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//                        return methodProxy.invokeSuper(o, args);
//                    }
//                });
//            }
//        } catch (Exception e) {
//            System.out.println("发生异常的次数:" + i);
//            e.printStackTrace();
//        } finally {
//
//        }
//    }

    public static void main(String[] args) {
        testOverThread();
    }
}
