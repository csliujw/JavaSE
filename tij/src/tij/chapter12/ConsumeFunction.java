package tij.chapter12;

import java.util.function.Function;

class One {
}

class Two {
}


public class ConsumeFunction {
    // 传了一个函数。
    static Two consume(Function<One, Two> onetwo) {
        // 开始使用
        return onetwo.apply(new One());
    }

    public static void main(String[] args) {
        Two two = consume(one -> new Two());
    }
}
