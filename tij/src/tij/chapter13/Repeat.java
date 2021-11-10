package tij.chapter13;

import java.util.stream.IntStream;

public class Repeat {
    public static void repeat(int n, Runnable action) {
        IntStream.range(0, n).forEach(i -> action.run());
    }

    static void hi() {
        System.out.println("hi");
    }

    public static void main(String[] args) {
        repeat(3, () -> System.out.println("Loop"));
        repeat(2, Repeat::hi);
    }
}
