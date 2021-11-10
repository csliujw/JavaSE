package video.generic;

import java.util.ArrayList;

/**
 * 通配符的用法
 * <? extends Number> 规定上限 ?得是Number或Number的子类
 * <? super Dog>   规定下限 ?得是Dog类型或Dog类型的父类
 */
public class WildCard {
    public static void main(String[] args) {
        WildCardDemo wildCardDemo = new WildCardDemo();

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        WildCardDemo.showNumber(list1);

        ArrayList<Double> list2 = new ArrayList<>();
        list2.add(1.2);
        WildCardDemo.showNumber(list2);

//        ArrayList<String> list3 = new ArrayList<>();
//        list3.add("1.2 +");
//        WildCardDemo.showNumber(list3); // 会报错！类型不对！

    }
}

class WildCardDemo {
//    // 伪泛型 这样写会报错。因为泛型最后都是变成Object，即ArrayList<Object>
//    public static void showBox(ArrayList<Number> list) {
//        Number number = list.get(0);
//        System.out.println(number);
//    }
//
//    public static void showBox(ArrayList<String> list) {
//        String str = list.get(0);
//        System.out.println(str);
//    }

    // 类型通配符是类型实参 而不是类型形参
    public static void showBox(ArrayList<?> list) {
        Object o = list.get(0);
        System.out.println(o);
    }

    // 类型通配符上限。 此处的最高上限是Number
    public static void showNumber(ArrayList<? extends Number> list) {
        System.out.println(list.get(0));
    }
}
