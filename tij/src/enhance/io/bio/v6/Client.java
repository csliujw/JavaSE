package enhance.io.bio.v6;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.Socket;

/**
 * 实现任意文件的上传
 */
public class Client {
    public static void main(String[] args) {
        try {
            // 1. 请求与服务端的socket连接
            Socket socket = new Socket("127.0.0.1", 9999);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(".pdf");
            FileInputStream inputStream = new FileInputStream("D:\\file.pdf");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                dataOutputStream.write(buffer, 0, len);
            }
            dataOutputStream.flush();
//            socket.shutdownOutput();
            dataOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
