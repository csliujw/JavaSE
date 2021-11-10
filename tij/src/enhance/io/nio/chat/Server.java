package enhance.io.nio.chat;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class Server {
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private final static int PORT = 9999;

    // 初始化连接信息
    public Server() {
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(PORT));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        // 监听
        server.listen();
    }

    // 监听事件
    private void listen() {
        try {
            while (selector.select() > 0) {
                System.out.println("=========start listen=========");
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey event = iterator.next();
                    if (event.isAcceptable()) {
                        // 客户端接入请求 连接事件
                        SocketChannel accept = serverSocketChannel.accept();
                        accept.configureBlocking(false);
                        accept.register(selector, SelectionKey.OP_READ);
                    } else if (event.isReadable()) {
                        // 读取数据请求 读取事件的请求
                        readData(event);
                    }
                    iterator.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readData(SelectionKey event) {
        // Java 7 try catch resource
        SocketChannel channel = null;
        try {
            channel = (SocketChannel) event.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int count = channel.read(buffer);
            if (count > 0) {
                String msg = new String(buffer.array(), 0, count);
                System.out.format("from %s 客户端的消息 %s", channel.getRemoteAddress(), msg);
                sendToAll(msg, channel);
            }
        } catch (Exception e) {
            // 抛出异常说明读不到消息。（离线了？）
            try {
                System.out.println(channel.getRemoteAddress().toString().split(":")[0] + "离线了");
                e.printStackTrace();
                // 因为它离线了！！所以取消这个事件。以后不在管这个通道
                event.cancel();
                //离线了，通道也应该关闭。
                channel.close();
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
    }

    // 把消息发送给除了自己外的所有人
    // 发送消息给其他人是通过
    private void sendToAll(String msg, SocketChannel self) {
        // 查看是否是同一个线程进行处理的。
        System.out.println("服务器开始转发消息, 当前处理的线程:" + Thread.currentThread().getName());
        try {
            for (SelectionKey key : selector.keys()) {
                SelectableChannel channel = key.channel();
                // 通道类型必须是SocketChannel，因为我们只要把消息转发给Client， 需要排除ServerSocketChannel
                if (channel instanceof SocketChannel && channel != self) {
                    SocketChannel dest = (SocketChannel) channel;
                    // 查看源码 warp会为我们创建一个缓冲区，这个缓冲区大小刚刚好可以放下所有数据。
                    dest.write(ByteBuffer.wrap(msg.getBytes()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 这块代码有问题。
    private void sendToAll2(String msg) {
        try {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            while (iterator.hasNext()) {
                SelectionKey event = iterator.next();
                SocketChannel channel = (SocketChannel) event.channel();
                channel.configureBlocking(false);
                byte[] bytes = msg.getBytes();
                ByteBuffer allocate = ByteBuffer.allocate(bytes.length);
                allocate.put(bytes);
                channel.write(allocate);
            }
            iterator.remove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
