package tij.chapter17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadLineStream {
    public static void main(String[] args) throws IOException {
        // 跳过前两行，选择下一行进行打印
        Files.lines(Paths.get("D:\\Code\\Java\\JavaSE\\src\\chapter17\\Find.java"))
                .skip(2)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
