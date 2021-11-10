package enhance.io.nio.selector;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * NIO 非阻塞式通信 入门案例。
 * NIO代码写起来的确不舒服。
 */
public class NIOServer {
    public static void main(String[] args) {
        try {
            System.out.println("=============服务端启动=============");
            // 获取服务端通道。（通道进行通信）接收客户端的连接请求
            ServerSocketChannel open = ServerSocketChannel.open();
            // 切换为非阻塞模式
            open.configureBlocking(false);
            // 绑定连接端口
            open.bind(new InetSocketAddress(9999));
            // 得到选择器
            Selector selector = Selector.open();
            // 将通道注册到选择器中 指定事件为：接收事件
            open.register(selector, SelectionKey.OP_ACCEPT);
            // 使用selector选择器轮询已经就绪好的事件
            while (selector.select() > 0) {
                // 获取选择器中所有注册的通道中 已经就绪好的事件
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                // 开始遍历这些准备好的事件
                while (iterator.hasNext()) {
                    // 提取一个事件
                    SelectionKey next = iterator.next();
                    // 判断是何种事件 如果是接入事件
                    if (next.isAcceptable()) {
                        // 直接获取接入的客户端通道
                        SelectableChannel channel = open.accept();
                        // 设置为非阻塞模式
                        channel.configureBlocking(false);
                        // 将该客户端通道注册到选择器
                        channel.register(selector, SelectionKey.OP_READ);
                    } else if (next.isReadable()) {
                        // 如果是读事件，获取当前选择器上的读就绪事件。
                        SocketChannel channel = (SocketChannel) next.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        int len = 0;
                        while ((len = channel.read(buffer)) > 0) {
                            buffer.flip();
                            System.out.println(new String(buffer.array(), 0, len));
                            buffer.clear(); // 清除之前的数据，不是真正的清除数据，而是所有的指针（标记）都初始化。
                        }
                    }
                    iterator.remove(); // 处理完毕后要移除当前事件。
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
