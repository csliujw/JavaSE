package tij.chapter19;

import java.util.stream.Stream;

public class ID2 {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return "ID2{" + "id=" + id + '}';
    }

    public static void main(String[] args) {
        Stream.generate(new DynamicSupplier<>(ID2.class))
                .skip(5).limit(5)
                .forEach(System.out::println);
    }
}
