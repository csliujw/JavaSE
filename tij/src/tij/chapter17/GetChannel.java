package tij.chapter17_stander_io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {
    private static String name = "data.txt";
    private static final int B_SIZE = 1024;

    public static void writer() {
        ByteBuffer.allocate(10);
        try (FileChannel fc = new FileOutputStream(name).getChannel()) {
            fc.write(ByteBuffer.wrap("Some text".getBytes())); // ByteBuffer.wrap 包装现有字节数组到 ByteBuffer
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void append() {
        try (FileChannel fc = new RandomAccessFile(name, "rw").getChannel()) {
            // 移动到文件末尾
            fc.position(fc.size());
            fc.write(ByteBuffer.wrap("Some more".getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void read() {
        try (FileChannel fc = new FileInputStream(name).getChannel()) {
            ByteBuffer allocate = ByteBuffer.allocate(B_SIZE);
            fc.read(allocate);
            allocate.flip();
            while (allocate.hasRemaining()) {
                System.out.write(allocate.get());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.flush();
    }

    public static void main(String[] args) {
        writer();
        append();
        read();
    }
}
