package enhance.io.nio.base;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * 主要用于：把原通道数据复制到目标通道
 */
public class TransferFrom {
    public void test() {
        try {
            FileChannel inputChannel = new FileInputStream("D:\\Code\\Java\\JavaEE\\concurrent\\src\\main\\resources\\data1.txt").getChannel();
            FileChannel outChannel = new FileOutputStream("D:\\Code\\Java\\JavaEE\\concurrent\\src\\main\\resources\\data3.txt").getChannel();
            outChannel.transferFrom(inputChannel, inputChannel.position(), inputChannel.size());
            inputChannel.close();
            outChannel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
