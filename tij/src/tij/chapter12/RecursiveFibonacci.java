package tij.chapter12;

public class RecursiveFibonacci {
    static IntCall1 fib;

    public static void main(String[] args) {
        // 三元 if else、
        // n==0 就返回0，不等于0就 n == 1 ? 1 : fib.call(n - 1) + fib.call(n - 2)
        fib = n -> n == 0 ? 0 : n == 1 ? 1 : fib.call(n - 1) + fib.call(n - 2);
        System.out.println(fib.call(16));
    }
}

interface IntCall1 {
    int call(int args);
}
