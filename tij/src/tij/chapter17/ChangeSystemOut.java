package tij.chapter17_stander_io;


import java.io.IOException;
import java.io.PrintWriter;

public class ChangeSystemOut {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Hello World Java");
        for (int i = 0; i < 1000; i++) {
            out.print("progress: " + i + "\r");//这个我只是给你个提示 我这里没测试
        }
        out.println(12);

    }
}
