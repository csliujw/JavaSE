import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Primer {
    // 暴力解法，一个一个判断
    boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // 优化。质数的性质。

    /**
     * 如果 d|n 则 n/d | n，只枚举 d ≤ n/d
     */
    boolean isPrime2(int n) {
        if (n < 2) return false;
        // 推荐这么写，时间复杂的 根号n。不推荐 sqrt(n)
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    static void divide(int n) {
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                int s = 0;
                while (n % i == 0) {
                    s++;
                    n /= i;
                }
                System.out.println(i + " " + s);
            }
        }
        if (n > 1) System.out.println(n + " " + 1);
        System.out.println();
    }

    static boolean st[]; // 判断是否被筛掉了
    static int[] nums; // 记录素数
    static int cnt; // 记录素数的总个数


    static void get_divisors(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n / i; i++) {
            if (n % i == 0) {
                list.add(i); // i 是一个约数，放进来。
                // n / i 可能也是一个约束，但是要判断下，避免 i * i = n 这种情况。
                if (i != n / i) list.add(n / i);
            }
        }
        list.sort(Comparator.reverseOrder());
        list.stream().forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        get_divisors(10);
    }
}
