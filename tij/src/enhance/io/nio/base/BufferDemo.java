package enhance.io.nio.base;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class BufferDemo {

    public void allocate() {
        // 分配大小为10的缓冲区
        ByteBuffer allocate = ByteBuffer.allocate(10);
        System.out.println(allocate.position()); // 0
        System.out.println(allocate.limit()); // 10
        System.out.println(allocate.capacity()); // 10
        System.out.println("==========================");
        // 缓冲区中添加数据
        allocate.put("liujiwas".getBytes(StandardCharsets.UTF_8));
        System.out.println(allocate.position()); // 8 写模式下是 当前可写入数据的位置
        System.out.println(allocate.limit()); // 10
        System.out.println(allocate.capacity()); // 10
        System.out.println("==========================");
        // flip方法 为缓冲区界限设置为当前位置，并将当前位置设置为0; 模式切换为可读模式
        allocate.flip();
        System.out.println(allocate.position()); // 读模式下是开始读数据的位置。
        System.out.println(allocate.limit()); // 读模式下是 可读的最后一个位置。
        System.out.println(allocate.capacity()); // 缓冲区总容量
        System.out.println("==========================");
        // get进行数据读取
        char b = (char) allocate.get();
        System.out.println(allocate.position());
        System.out.println(allocate.limit());
        System.out.println(allocate.capacity());
    }

    public void api() {
        ByteBuffer allocate = ByteBuffer.allocate(10);
        allocate.put("liujiwas".getBytes(StandardCharsets.UTF_8));
        System.out.println(allocate.position());
        System.out.println(allocate.limit());
        System.out.println(allocate.capacity());
        System.out.println("==========================");
        // clear 清除缓冲区的数据
        allocate.clear(); // 看源码 只是重置position的位置，数据其实还是存在的。
        System.out.println(allocate.position());
        System.out.println(allocate.limit());
        System.out.println(allocate.capacity());
        System.out.println((char) allocate.get());
        System.out.println("==========================");
    }

    public void apiFlip() {
        ByteBuffer allocate = ByteBuffer.allocate(10);
        allocate.put("itlww".getBytes(StandardCharsets.UTF_8));
        allocate.flip();
        byte[] buf = new byte[2];
        allocate.get(buf);
        System.out.println(new String(buf));
        System.out.println("==========================");

        allocate.mark(); // 标记此刻的位置。

        allocate.get(buf);
        System.out.println(new String(buf));
        System.out.println("==========================");

        allocate.reset(); // 回到标记位置
        if (allocate.hasRemaining()) {
            System.out.println(allocate.remaining());
        }
    }

    public void read() {
        ByteBuffer allocate = ByteBuffer.allocate(10);
        allocate.put("1234567890".getBytes(StandardCharsets.UTF_8));
        allocate.flip(); // 读模式
        byte[] buf = new byte[8];

        // 利用剩余元素 进行循环判断，是否可继续读，读多少。
        while (allocate.hasRemaining()) {
            int elementCount = allocate.remaining();
            if (elementCount >= 8) {
                allocate.get(buf);
                System.out.println(new String(buf));
            } else {
                allocate.get(buf, 0, elementCount);
                System.out.println(new String(buf, 0, elementCount));
            }
        }
    }
}
