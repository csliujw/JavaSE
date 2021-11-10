package tij.string;

import org.junit.Test;

public class StringDemo {
    @Test
    public void testIntern() {
        String x2 = new String("c") + new String("d");
        String x1 = "cd";
        //        x2.intern();  // cd 在常量池中，尝试把x2放入常量池中失败。
        // 问，如果调换了【最后两行代码】的位置呢，如果是jdk1.6呢
        System.out.println(x1 == x2); // false
    }

    @Test
    public void join() {
        String join = String.join(",", "Hello", "Golang");
        System.out.println(join);
    }

    @Test
    public void format() {
        System.out.println(String.format("Hello %s. I am XX", "tomcat"));
    }
}
