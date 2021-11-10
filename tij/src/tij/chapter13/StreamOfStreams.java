package tij.chapter13;

import java.util.stream.Stream;

public class StreamOfStreams {
    public static void main(String[] args) {
        // 产生了一个 Stream 流， forEach 逐个打印流中的元素
        Stream.of(1, 2, 3, 4).forEach(System.out::println);
        System.out.println("===============");

        // 产生了一个 Stream 流 的流。 of 一层 Stream，map 里又后，为 1 2 3 4 又套了一层流。流的流。
        // 所以最后打印的是流中的元素（元素流的流）
        Stream.of(1, 2, 3, 4).map(i -> Stream.of("Gonzo", "Fozzie", "Beaker")).forEach(System.out::println);
        System.out.println("===============");

        // 如何解决呢？flat 展平
        Stream.of(1, 2, 3, 4).flatMap(i -> Stream.of("Gonzo", "Fozzie", "Beaker")).forEach(System.out::println);
    }
}
