package tij.chapter13;

import java.util.Arrays;
import java.util.Comparator;

public class SortedComparator {
    public static void main(String[] args) throws Exception {
        Arrays.stream(new String[]{"!@!#", "A", "B", "s", "ASFASF"})
                .limit(10)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::print);
    }
}
