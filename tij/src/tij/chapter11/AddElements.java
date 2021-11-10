package tij.chapter11;

import java.util.*;

public class AddElements {
    public static void main(String[] args) {
        Collection<Integer> elements = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ArrayList<Integer> elements2 = new ArrayList<>();
        // 运行速度更快
        Collections.addAll(elements2, 1, 2, 3, 4, 5, 6);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        list.set(1, 100);
//        list.add(100); 报错，asList 产生的集合大小是不可变的，会抛出 Unsupported Operation
    }
}
