package tij.chapter13;

import java.util.Arrays;
import java.util.Random;

public class RandInts {
    public static void main(String[] args) {
        int[] ints = new Random(47).ints(0, 1000).limit(100).toArray();
        Arrays.stream(ints);
    }
}
