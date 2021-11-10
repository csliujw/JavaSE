package enhance.io.bio.v8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * 目标：BIO模式下的端口转发思想-服务端实现
 * 服务端实现的需求：
 * 1.注册端口
 * 2.接收客户端的socket连接，交给一个独立的线程来处理
 * 3.把当前连接的客户端socket存入到一个所谓的在线socket集合中保存
 * 4.接收客户端的消息，然后推送给当前所有在线的socket接收
 */
public class Server {
    public static ArrayList<Socket> onLineSocket = new ArrayList<>(16);

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            while (true) {
                Socket accept = serverSocket.accept();
                // 把登录的客户端存入到一个在线集合中。
                onLineSocket.add(accept);
                // 为登录成功的socket分配一个线程进行处理
                new Thread(new ServerReaderThread(accept)).start();
            }
        } catch (Exception e) {

        }
    }
}

class ServerReaderThread implements Runnable {
    private Socket socket;

    public ServerReaderThread() {

    }

    public ServerReaderThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg;
            while ((msg = bufferedReader.readLine()) != null) {
                // 服务端接收到数据后，把消息传给所有的在线用户
                sendMsgToAllClient(msg);
            }
        } catch (Exception e) {
            System.out.println("有人下线");
            Server.onLineSocket.remove(socket);
            e.printStackTrace();
        }
    }

    private void sendMsgToAllClient(String msg) {
        try {
            for (Socket sk : Server.onLineSocket) {
                if (sk == socket) continue;
                // 包装一下，用PrintStream的方式传递数据。知道是哪个socket，就可以直接给这个socket发送数据了。
                PrintStream printStream = new PrintStream(sk.getOutputStream());
                printStream.println(msg);
                printStream.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
