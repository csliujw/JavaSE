package tij.chapter17;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class RmDir {
    public static void rmdir(Path dir) throws IOException {
        Path path = Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                // 继续遍历
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path dir, BasicFileAttributes attrs) throws IOException {
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public static void main(String[] args) throws IOException {
        Path delete = Paths.get("D:", "Delete");
        rmdir(delete);
    }
}
