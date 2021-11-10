package tij.chapter12;

import java.util.function.Function;

public class CurryingAndPartials {
    // 未柯里化:
    static String uncurried(String a, String b) {
        return a + b;
    }

    public static void main(String[] args) {
        // 柯里化的函数: 柯里化两参数
        Function<String, Function<String, String>> sum = a -> b -> a + b;

        System.out.println(uncurried("Hi", "Ho"));

        // 使用 柯里化函数
        Function<String, String> hi = sum.apply("Hi");
        System.out.println(hi.apply("Ho"));

        // 部分应用
        Function<String, String> sumHi = sum.apply("Hup");
        System.out.println(sumHi.apply("Ho")); // 每次只传入一个参数，然后多次操作
        System.out.println(sumHi.apply("Hey"));
    }
}

