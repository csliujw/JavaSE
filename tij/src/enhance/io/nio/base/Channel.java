package enhance.io.nio.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Channel {
    // 使用NIO进行文件的复制
    public void copy() {
        try {
            // File 从classes下开始找文件
            File src = new File("D:\\Code\\Java\\JavaEE\\concurrent\\src\\main\\resources\\demo.png");
            File dest = new File("D:\\Code\\Java\\JavaEE\\concurrent\\src\\main\\resources\\new.png");
            FileChannel inputChannel = new FileInputStream(src).getChannel();
            FileChannel outputChannel = new FileOutputStream(dest).getChannel();
            // 定义缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (true) {
                // 必须先清空我们的缓冲区，然后再写入数据到缓冲区。
                buffer.clear();
                int flag = inputChannel.read(buffer);
                if (flag == -1) break;
                // 已经读取数据，切换缓冲区模式为可读模式
                buffer.flip();
                // 缓冲区数据写出去了
                outputChannel.write(buffer);
            }
            inputChannel.close();
            outputChannel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
