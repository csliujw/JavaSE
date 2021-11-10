package jvm.ref;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class SoftReferenceDemo {
    static int _4MB = 4 * 1024 * 1024;

    public static void strongRef() {
        List<byte[]> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new byte[_4MB]);
        }
    }

    public static void soft() {
        ReferenceQueue<byte[]> queue = new ReferenceQueue<>();
        List<SoftReference<byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            // 关联了软引用队列，当软引用所关联的 byte[] 被回收时，软引用自己会加入软引用队列中取去。
            SoftReference<byte[]> soft = new SoftReference<byte[]>(new byte[_4MB], queue);
            System.out.println(soft.get());
            list.add(soft);
            System.out.println(list.size());
        }
        // 从队列中获取无用的 软引用对象，并移除
        Reference<? extends byte[]> poll = queue.poll();
        while (poll != null) {
            list.remove(poll);
            poll = queue.poll();
        }

        System.out.println("循环结束：" + list.size());
        for (SoftReference<byte[]> reference : list) {
            System.out.println(reference.get());
        }
    }

    public static void main(String[] args) {
//        strongRef();
        soft();
    }
}