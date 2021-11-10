package tij.chapter13;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOfRandoms {
    static Random random = new Random(45);

    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5)
                .flatMapToInt(i -> IntStream.concat(random.ints(0, 100).limit(3), IntStream.of(-1)))
                .forEach(System.out::print);
    }
}
