package tij.chapter17;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AddAndSubtractPaths {
    static Path base = Paths.get("..", "..", "..").toAbsolutePath().normalize();

    static void show(int id, Path result) {
        if (result.isAbsolute()) {
            System.out.println("(" + id + ")r " + base.relativize(result));
        } else {
            System.out.println("(" + id + ") " + result);
        }
    }

    @Test
    public void test1() {
        Path p = Paths.get("AddAndSubtractPaths.java").toAbsolutePath();
        // (1)r Code\Java\JavaSE\AddAndSubtractPaths.java
        show(1, p);
    }

    @Test
    public void test2() {
        Path p = Paths.get("AddAndSubtractPaths.java").toAbsolutePath();
        Path convoluted = p.getParent()
                .getParent()
                .resolve("strings")
                .resolve("..")
                .resolve(p.getParent().getFileName());
        System.out.println(convoluted.toAbsolutePath());
        // (2)r Code\Java\JavaSE
        show(2, convoluted);
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
//        System.out.println(base);
        Path p = Paths.get("AddAndSubtractPaths.java").toAbsolutePath();
        show(1, p);
        /*
        Path convoluted = p.getParent()
                .getParent()
                .resolve("strings")
                .resolve("..")
                .resolve(p.getParent().getFileName());

        show(2, convoluted);
        show(3, convoluted.normalize());
        Path p2 = Paths.get("..", "..");
        show(4, p2);
        show(5, p2.normalize());
        show(6, p2.toAbsolutePath().normalize());
        Path p3 = Paths.get(".").toAbsolutePath();
        Path p4 = p3.resolve(p2);
        show(7, p4);
        show(8, p4.normalize());
        Path p5 = Paths.get("").toAbsolutePath();
        show(9, p5);
        show(10, p5.resolveSibling("strings"));
        show(11, Paths.get("nonexistent"));
        */
    }
}
