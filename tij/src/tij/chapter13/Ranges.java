package tij.chapter13;

import java.util.stream.IntStream;

public class Ranges {
    public static void main(String[] args) {
        int result = 0;
        for (int i = 0; i < 50; i++) {
            result += i;
        }

        System.out.println(result);
        result = 0;
        for (int i : IntStream.range(0, 50).toArray()) {
            result += i;
        }
        System.out.println(result);

        System.out.println(IntStream.range(0, 50).sum());
    }
}
