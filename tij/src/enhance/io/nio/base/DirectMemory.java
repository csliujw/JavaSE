package enhance.io.nio.base;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class DirectMemory {
    public static void main(String[] args) {
        DirectMemory directMemory = new DirectMemory();
        directMemory.write();
        directMemory.read();
    }

    public boolean direct() {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024 * 20);
        return byteBuffer.isDirect();
    }

    public void write() {
        try {
            // FileInputStream从项目根路径开始找
            FileChannel channel = new FileOutputStream("src/write.txt").getChannel();
            ByteBuffer allocate = ByteBuffer.allocate(1024);
            allocate.put("hello world java nio".getBytes());
            // position is set to zero
            allocate.flip();
            channel.write(allocate);
            channel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void read() {
        try {
            String path = this.getClass().getClassLoader().getResource("read.txt").getPath();
            FileChannel channel = new FileInputStream(path).getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int read = channel.read(buffer);
            buffer.flip();
            //  System.out.println(allocate.array().length); 1024 size
            System.out.println(new String(buffer.array(), 0, buffer.remaining()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
