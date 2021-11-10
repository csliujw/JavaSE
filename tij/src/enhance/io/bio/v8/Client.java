package enhance.io.bio.v8;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            // 1、创建于服务端的Socket链接
            Socket socket = new Socket("127.0.0.1", 9999);
            // 4、分配一个线程为客户端socket服务接收服务端发来的消息
            new ClientReaderThread(socket).start();

            // 2、从当前socket管道中得到一个字节输出流对应的打印流
            PrintStream ps = new PrintStream(socket.getOutputStream());
            // 3、接收用户输入的消息发送出去
            Scanner sc = new Scanner(System.in);
            while (true) {
                String msg = sc.nextLine();
                ps.println("波妞：" + msg);
                ps.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class ClientReaderThread extends Thread {
    private Socket socket;

    public ClientReaderThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg;
            while ((msg = br.readLine()) != null) {
                System.out.println(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
