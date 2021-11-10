package tij.chapter13;

import java.util.Arrays;

public class ArrayStreams {
    public static void main(String[] args) {
        Arrays.stream(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}).forEach(System.out::print);
        System.out.println();
        Arrays.stream(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 2, 5).forEach(System.out::print);
    }
}
