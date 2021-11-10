package tij.chapter17;

import java.util.Random;
import java.util.stream.Collectors;

public class UsingStringBuilder {
    public static String string1() {
        Random rand = new Random(47);
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < 25; i++) {
            result.append(rand.nextInt(100));
            result.append(", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("]");
        return result.toString();
    }

    public static String string2() {
        String result = new Random(47).ints(25, 0, 100).mapToObj(Integer::toString)
                .collect(Collectors.joining(", ")); // 加入 ， 进行区分
        return "[" + result + "]";
    }

    public static void main(String[] args) {
        System.out.println(string1());
        System.out.println(string2());
    }
}