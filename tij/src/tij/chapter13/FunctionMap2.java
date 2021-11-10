package tij.chapter13;

import java.util.stream.Stream;

class Numbered {
    final int n;

    Numbered(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "Numbered(" + n + ")";
    }
}

public class FunctionMap2 {
    public static void main(String[] args) {
        Stream.of(1, 5, 7, 9, 11, 13)
                // 将 int 映射为 Numbered 类型
                .map(Numbered::new)
                .forEach(System.out::println);
    }
}
