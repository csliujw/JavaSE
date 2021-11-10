package enhance.io.nio.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.channels.FileChannel;

public class NIODemo {
    public static void main(String[] args) throws FileNotFoundException {
        FileChannel channel = new FileInputStream("a.txt").getChannel();
    }
}
