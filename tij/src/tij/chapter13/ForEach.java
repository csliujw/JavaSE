package tij.chapter13;

import java.util.Arrays;
import java.util.Random;

public class ForEach {
    static final int SZ = 8;

    public static void main(String[] args) {
        int[] ints = new Random(47).ints(0, 1000).limit(SZ).toArray();
        Arrays.stream(ints).forEach(n -> System.out.format("%d \t", n));
        System.out.println();
        Arrays.stream(ints).parallel().forEach(n -> System.out.format("%d \t", n));
        System.out.println();
        Arrays.stream(ints).parallel().forEachOrdered(n -> System.out.format("%d \t", n));
    }
}