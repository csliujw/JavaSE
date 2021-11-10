package enhance.io.bio.v4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

// 服务器端 因为只一次accept 只接受到了一个客户端的请求，所以只能接受到一个客户端的消息。
// 我们为每个客户端创建一个线程，就可以一个服务器 连接多个客户端了！
public class BIOServer {
    public static void main(String[] args) throws IOException {
        System.out.println("========服务端启动========");
        // 1. 定义一个ServerSocket对象进行服务器的端口注册
        ServerSocket serverSocket = new ServerSocket(9999);
        while (true) {
            // 2. 开始在这里暂停等待接收客户端的连接,得到一个端到端的Socket管道
            Socket accept = serverSocket.accept();
            new Thread(new DealClient(accept)).start();
        }
    }
}

class DealClient implements Runnable {
    private Socket socket = null;

    public DealClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        try {
            // 3. 从Socket管道中得到一个字节输入流。
            inputStream = socket.getInputStream();
            // 4. 把字节输入流包装成自己需要的流进行数据的读取。
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            // 5. 读取数据
            String msg = "";
            while ((msg = bufferedReader.readLine()) != null) {
                System.out.println("服务器端接收到：" + socket.getRemoteSocketAddress() + ":\t" + msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
