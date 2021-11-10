package enhance.io.bio.v6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        while (true) {
            Socket accept = serverSocket.accept();
            new Thread(() -> {
                try {
                    DataInputStream dataInputStream = new DataInputStream(accept.getInputStream());
                    String suffix = dataInputStream.readUTF();
                    FileOutputStream fileOutputStream = new FileOutputStream("D:\\demo" + suffix);
                    byte[] buffer = new byte[1024];
                    int len = 0;
                    while ((len = dataInputStream.read(buffer)) != -1) {
                        fileOutputStream.write(buffer, 0, len);
                    }
                    fileOutputStream.close();
                    dataInputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
