package tij.chapter12;

import java.util.function.Function;

interface FP extends Function<String, String> {
}

public class ProduceFunction {
    static FP product() {
        // 产生了一个函数，（实际上是一个对象，假装是函数）。
        return s -> s.toLowerCase();
    }

    public static void main(String[] args) {
        FP f = product();
        System.out.println(f.apply("helloASDF"));
    }
}
