package tij.chapter17;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamInAndOut {
    public static void main(String[] args) {
        try (Stream<String> lines = Files.lines(Paths.get("D:\\Code\\Java\\JavaSE\\src\\chapter17\\FileSystemDemoCopy.java"));
             PrintWriter out = new PrintWriter("StreamInAndOut.txt");
        ) {
            lines.map(String::toUpperCase)
                    .forEachOrdered(out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
