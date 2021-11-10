package jvm.ref;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 演示软引用
 * -Xmx20m -XX:+PrintGCDetails -verbose:gc
 */
public class Demo2_3 {

    private static final int _4MB = 4 * 1024 * 1024;

    // 同样是加了5次，但是 soft 不会OOM
    public static void main(String[] args) throws IOException {
//        List<byte[]> list = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            list.add(new byte[_4MB]);
//        }
//        System.in.read();
        soft();
    }

    public static void soft() {
        // list --> SoftReference --> byte[]

        List<SoftReference<byte[]>> list = new ArrayList<>();
        // List 引用软引用 软引用应用 byte 数组
        for (int i = 0; i < 5; i++) {
            // 构造软引用。 感觉就是 用软 包裹 强 让强变成软
            SoftReference<byte[]> ref = new SoftReference<>(new byte[_4MB]);
            System.out.println(ref.get());
            list.add(ref);
            System.out.println(list.size());
        }
        System.out.println("循环结束：" + list.size());
        for (SoftReference<byte[]> ref : list) {
            System.out.println(ref.get());
        }
    }
}
