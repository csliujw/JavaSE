package enhance.io.nio.base;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 分散和聚集：意思就是提供多个缓冲区用于收集数据，把数据分散到每个缓冲区去，读取的时候也是从每个缓冲区中读。
 */
public class ScatterGather {
    public void demo() {
        try {
            FileChannel inputChannel = new FileInputStream("D:\\Code\\Java\\JavaEE\\concurrent\\src\\main\\resources\\data1.txt").getChannel();
            FileChannel outChannel = new FileOutputStream("D:\\Code\\Java\\JavaEE\\concurrent\\src\\main\\resources\\data2.txt").getChannel();
            ByteBuffer[] byteBuffers = {ByteBuffer.allocate(4), ByteBuffer.allocate(1024)};
            inputChannel.read(byteBuffers);
            for (ByteBuffer buffer : byteBuffers) {
                buffer.flip();
                String string = new String(buffer.array(), 0, buffer.remaining());
                System.out.println(string);
            }
            outChannel.write(byteBuffers);
            outChannel.close();
            inputChannel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
