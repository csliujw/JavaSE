package tij.chapter17;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathInfo {
    static void show(String id, Object p) {
        System.out.println(id + ": " + p);
    }

    static void info(Path p) {
        show("toString", p);
        show("Exists", Files.exists(p)); //文件是否存在
        show("RegularFile", Files.isRegularFile(p));
        show("Directory", Files.isDirectory(p));
        show("Absolute", p.isAbsolute());
        show("FileName", p.getFileName()); // 返回当前文件名
        show("Parent", p.getParent());
        show("Root", p.getRoot());
        System.out.println("******************");
    }

    @Test
    public void demo1() {
        System.out.println(System.getProperty("os.name")); // 展示操作系统的名
        System.out.println("======================================================");
        info(Paths.get("C:", "path", "to", "nowhere", "NoFile.txt"));
        Path p = Paths.get("PathInfo.java");
        info(p);
        Path ap = p.toAbsolutePath();
        info(ap);
        info(ap.getParent());
        try {
            info(p.toRealPath());
        } catch (IOException e) {
            System.out.println(e);
        }
        URI u = p.toUri();
        System.out.println("URI: " + u);
        Path puri = Paths.get(u);
        System.out.println(Files.exists(puri));
        File f = ap.toFile(); // Don't be fooled 表示目录或者文件本身
    }

    @Test
    public void osName() {
        System.out.println(System.getProperty("os.name"));
    }

    public void show(Path path) {
        System.out.println(path);
        System.out.println("是否存在" + Files.exists(path));
        // 有没有被隐藏什么的。
        System.out.println("常规文件" + Files.isRegularFile(path));
        System.out.println("是否是目录" + Files.isDirectory(path));
        System.out.println("是否是绝对路径" + path.isAbsolute());
        System.out.println("文件名" + path.getFileName());
        System.out.println("父级目录" + path.getParent());
        System.out.println("根目录" + path.getRoot());
    }

    @Test
    public void pathMethod() {
        // 构建一个 path 对象。
        Path path = Paths.get("C:", "path", "to", "nowhere", "NOFile.txt");
        show(path);
    }

    @Test
    public void paths() {
        Path path = Paths.get("PathInfo.java");
        show(path);
    }

    @Test
    public void toAbsolutePath() {
        Path path = Paths.get("PathInfo.java");
        Path path1 = path.toAbsolutePath();
        show(path1);
    }

    @Test
    public void toRealPath() throws IOException {
        Path path = Paths.get("PathInfo.java");
        Path path1 = path.toRealPath();
        show(path1);
    }

    @Test
    public void other() {
        System.out.println(System.getProperty("os.name"));
        Path p = Paths.get("PartsOfPaths.java").toAbsolutePath();
        for (int i = 0; i < p.getNameCount(); i++)
            System.out.println(p.getName(i));
        // 使用 endsWith() 比较的是整个路径部分，而不会包含文件路径的后缀
        System.out.println("ends with '.java': " +
                p.endsWith(".java"));
        for (Path pp : p) {
            System.out.print(pp + ": ");
            System.out.print(p.startsWith(pp) + " : ");
            System.out.println(p.endsWith(pp));
        }
        System.out.println("Starts with " +
                p.getRoot() + " " + p.startsWith(p.getRoot()));
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("PathInfo.java");
        System.out.println(path.toAbsolutePath());
        byte[] bytes = Files.readAllBytes(path);
        System.out.println(new String(bytes, 0, bytes.length));
//        show(path1);
    }
}