package tij.chapter17;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Writing {
    public static void main(String[] args) throws IOException {
        byte[] out = "Hello World Java".getBytes(StandardCharsets.UTF_8);
        Files.write(Paths.get("D:", "copy.txt"), out);

        ArrayList<String> list = new ArrayList<>();
        list.add("!23");
        list.add("!23");
        list.add("!23");
        Files.write(Paths.get("D:", "copy2.txt"), list);
    }
}
