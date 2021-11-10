package video.jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 软引用
 */
public class SoftReferenceDemo {
    static class SoftDemo {
    }

    public static void main(String[] args) throws InterruptedException {

        // 软引用指向new SoftDemo对象
        SoftReference<SoftDemo> softDemoSoftReference = new SoftReference<>(new SoftDemo());
        List<Object> l = new ArrayList<>();
        List<byte[]> list = new ArrayList<>();
        while (true) {
            TimeUnit.MILLISECONDS.sleep(10);
            list.add(new byte[1024 * 1024]);
        }
    }
}
