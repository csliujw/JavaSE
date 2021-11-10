package tij.chapter12;

import java.util.function.Function;

public class FunctionComposition {
    static Function<String, String> f1 = s -> {
        System.out.println(s);
        return s.replace('A', '_');
    },
            f2 = s -> s.substring(3),
            f3 = s -> s.toLowerCase(),
    // 这个啥意思？
    f4 = f1.compose(f2).andThen(f3);

    public static void main(String[] args) {
        // 当 f1 获得字符串时，它已经被 f2 剥离了前三个字符。这是因为 compose（f2）表
        //示 f2 的调用发生在 f1 之前。
        f4.apply("GO AFTER ALL AMBULANCES");
    }
}
