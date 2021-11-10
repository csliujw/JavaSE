package enhance.io.bio.v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

// 服务器端 可重复接受数据
public class BIOServer {
    public static void main(String[] args) throws IOException {
        System.out.println("========服务端启动========");
        // 1. 定义一个ServerSocket对象进行服务器的端口注册
        ServerSocket serverSocket = new ServerSocket(9999);
        // 2. 监听客户端的Socket链接请求
        Socket accept = serverSocket.accept();
        // 3. 从socket中得到字节输入流对象
        InputStream inputStream = accept.getInputStream();
        // 4.把字节输入流转为缓冲字符串输入流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String msg = "";
        // 服务端按行接受消息，
        while ((msg = bufferedReader.readLine()) != null) {
            System.out.println("服务器端接受到：" + msg);
        }
        bufferedReader.close();
        inputStream.close();
    }
}
