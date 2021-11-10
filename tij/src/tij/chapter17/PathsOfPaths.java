package tij.chapter17;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsOfPaths {

    @Test
    public void test1() {
        Path path = Paths.get("PathsOfPaths.java").toAbsolutePath();
        // Code/Java/JavaSE/PathsOfPaths.java
        for (int i = 0; i < path.getNameCount(); i++) {
            // 会输出 Code  Java JavaSE PathsOfPaths.java
            System.out.println(path.getName(i));
        }
        System.out.println("=================================");
        System.out.println("ends with '.java' " + path.endsWith(".java")); // false
        /**
         * Code
         * Java
         * JavaSE
         * PathsOfPaths.java
         * =================================
         * ends with '.java' false
         */
    }

    @Test
    public void test2() {
        Path path = Paths.get("PathsOfPaths.java").toAbsolutePath();
        // Path 内部实现了迭代器，迭代器迭代的是 路径的name
        for (Path tmp : path) {
            System.out.print(tmp + ": ");
            System.out.print(path.startsWith(tmp) + " : ");
            System.out.println(path.endsWith(tmp));
        }
        System.out.println("Starts with " + path.getRoot() + " " + path.startsWith(path.getRoot()));
        /**
         * Code: false : false
         * Java: false : false
         * JavaSE: false : false
         * PathsOfPaths.java: false : true
         * Starts with D:\ true
         */
    }
}
