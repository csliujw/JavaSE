package enhance.io.bio.v1;

import java.io.*;
import java.net.Socket;

// 客户端
public class BIOClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9999);
        OutputStream outputStream = socket.getOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        printStream.println("hello world server");
        printStream.flush();
        while (true) ;
    }
}
