package video.generic;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 泛型数组
 * - 可以声明带泛型的数组引用，但是不能直接创建带泛型的数组对象
 * - 可以通过java.lang.reflect.Array的newInstance(Class<T> ,int)创建T[]数组
 */
public class GenericArray {
    public static void main(String[] args) {
        // new ArrayList<String>[10];这块是会报错的
        // ArrayList<String>[] listArr = new ArrayList<String>[10];

        // ArrayList[] list = new ArrayList[5];  不安全 会越过泛型检查
        // ArrayList<String>[] listArr = list;

        // 没问题，有泛型检查。为什么数组不能直接new 泛型。因为泛型最后会被擦除，而数组会一直持有类型，这是冲突的！！
        ArrayList<String>[] listArr = new ArrayList[5];
        listArr[0] = new ArrayList<String>();
        System.out.println("=================");
        Fruit<ArrayList> fruit = new Fruit<>(ArrayList.class, 100);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        fruit.put(0, strings);
        ArrayList arrayList = fruit.get(0);
    }
}

class Fruit<T> {
    private T[] array;

    public Fruit(Class<T> clazz, int len) {
        array = (T[]) Array.newInstance(clazz, len);
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        if (index >= array.length)
            throw new IllegalArgumentException("索引越界");
        return array[index];
    }

}
