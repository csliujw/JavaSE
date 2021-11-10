package tij.chapter20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Fruits {

}

class Apples extends Fruits {

}

public class NoCovariantGenerics {

    public static void main(String[] args) {
        // 提供数据用 extends
        // 是 Number 的子类就可以加入集合
        List<? extends Number> list = Arrays.asList(new Integer(1), new Float(2));
        // 接收数据用 super
        List<? super Fruits> list2 = new ArrayList<>();
        list2.add(new Apples());
        list2.add(new Fruits());
    }
}
