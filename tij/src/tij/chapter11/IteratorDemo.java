package tij.chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();// 拿到元素
            System.out.println(next);
            iterator.remove(); // 删除由 next() 生成的最后一个元素
        }
        System.out.println(list.size());
    }
}
