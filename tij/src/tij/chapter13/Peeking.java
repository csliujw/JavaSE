package tij.chapter13;

import java.util.Arrays;

public class Peeking {
    public static void main(String[] args) {
        Arrays.stream(new int[]{1, 2, 5, 8, 25, 2, 5, 2, 5, 5, 2, 5, 582, 6, 146, 41})
                .skip(1)
                .limit(5)
                .map(w -> w % 2) // 执行完 map 后，用 peek 输出看下结果
                .peek(e -> System.out.println(e))
                .map(w -> w * 5) // 执行完 map 后，用 peek 输出看下结果
                .peek(e -> System.out.println(e))
                .forEach(System.out::print);
    }
}
