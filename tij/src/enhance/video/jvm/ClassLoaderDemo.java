package video.jvm;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ClassLoaderDemo {

    public static void testResources() throws IOException {
        ClassLoaderDemo classLoaderDemo = new ClassLoaderDemo();
        ClassLoader classLoader = classLoaderDemo.getClass().getClassLoader();
        // 获取文件的URL. classpath 下的资源哦！
        Enumeration<URL> resources = classLoader.getResources("org/example/video/jvm/DCL.class");
        while (resources.hasMoreElements()) {
            // file:/D:/Code/JavaEE/JavaSE/target/classes/org/example/video/jvm/DCL.class
            System.out.println(resources.nextElement());
        }
    }

    public void test() {
        // binary names 二进制名称
        // 就是 全类名
        /**
         * java.lang.String
         * javax.swing.Jspinner$DefaultEditor [$代表内部类]
         * java.security.KeyStore$Builder$FileBuilder$1 KeyStore的内部类是Builder，Builder的内部类是FileBuilder。 $1表示这是一个匿名内部类，取第一个匿名内部类
         * $ 代表内部类
         * $1 代表第一个内部类
         */
    }

    public static void main(String[] args) throws IOException {
        ClassLoaderDemo.testResources();
    }

}
