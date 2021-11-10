package enhance.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;

public class Client {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
        client.connect(new InetSocketAddress("localhost", 11111)).get();
        client.write(ByteBuffer.wrap("hello".getBytes()));
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int len = client.read(buffer).get();
        if (len > 0) {
            System.out.format("收到服务端数据 %s", new String(buffer.array(), 0, len));
        }
    }
}
