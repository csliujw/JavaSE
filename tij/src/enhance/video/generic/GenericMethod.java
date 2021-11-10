package video.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 泛型方法
 * - 泛型类，是在实例化类的时候指明泛型的具体类型
 * - 泛型方法，是在调用方法的时候指明泛型的具体类型
 * - 普通的成员方法如果采用了类的泛型，那么这个方法就不能被声明为static
 * - 但是泛型方法支持静态
 *
 * 泛型方法总结
 * - 泛型方法能使方法独立于类而产生变化
 * - 如果static方法要使用泛型能力，就必须使其成为泛型方法。
 */
public class GenericMethod<T> {
    public static void main(String[] args) {
        GenericMethod<String> method = new GenericMethod<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(11);
        // 泛型方法的泛型类型可以独立于泛型类！秒啊！
        Integer product = method.getProduct(list);
        // 即便和泛型类都有的T，仍然是独立的！！
        Integer product2 = method.getProduct2(list);
        System.out.println(product);
        System.out.println(product2);
        // 调用静态泛型方法
        GenericMethod.printType("100", 100, true);
        GenericMethod.print(1, 2, 3, 4, "\n");

        GenericMethod.print("A", "B", "C");
    }

    private T value;

    /**
     * 这才是泛型方法！！ 有<T>!!泛型方法在调用方法时才确定。
     * 这种写法有什么优势？？对不同类型的数据 进行相同操作的筛选？？
     * 即便把E写成T，和泛型类一致，泛型方法 仍可以和泛型类不一致！！
     *
     * @param list
     * @param <E>
     * @return
     */
    public <E> E getProduct(ArrayList<E> list) {
        return list.get(0);
    }

    public <T> T getProduct2(ArrayList<T> list) {
        return list.get(0);
    }

    /**
     * 定义了静态的泛型方法，而且采用多个泛型类型。
     *
     * @param t
     * @param e
     * @param k
     * @param <T>
     * @param <E>
     * @param <K>
     */
    public static <T, E, K> void printType(T t, E e, K k) {
        System.out.println("t " + t.getClass().getSimpleName());
        System.out.println("e " + e.getClass().getSimpleName());
        System.out.println("k " + k.getClass().getSimpleName());
    }

    public static <E> void print(E... e) {
        Stream.of(e).forEach(System.out::print);
    }

    public void setValue(T value) {
        this.value = value;
    }

    // 这个不是泛型方法！！
    public T getValue() {
        return value;
    }
}
