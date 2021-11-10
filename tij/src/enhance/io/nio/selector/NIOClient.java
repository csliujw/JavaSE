package enhance.io.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * NIO 非阻塞式客户端案例
 */
public class NIOClient {
    public static void main(String[] args) {
        try {
            System.out.println("=============客户端启动=============");
            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 9999));
            socketChannel.configureBlocking(false);
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("please input:");
                String msg = scanner.nextLine();
                buffer.put(msg.getBytes(StandardCharsets.UTF_8));
                buffer.flip();
                socketChannel.write(buffer);
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
