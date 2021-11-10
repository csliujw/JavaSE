package enhance.io.bio.v5;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

// 客户端 启动多个客户端 给通过一个服务器发送消息
public class Client {
    public static void main(String[] args) throws IOException {
        // 1.建立一个与服务端的Socket对象：套接字
        Socket socket = new Socket("127.0.0.1", 8888);
        // 2.从socket管道中获取一个输出流，写数据给服务端
        OutputStream outputStream = socket.getOutputStream();
        // 3.把输出流包装成一个打印流
        PrintStream printStream = new PrintStream(outputStream);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("please input:");
            String msg = scanner.nextLine();
            printStream.println(msg);
            printStream.flush();
        }
    }
}
