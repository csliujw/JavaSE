package tij.chapter20;

class Generic<T> {
    T t;

    Generic(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Generic{t=" + t.getClass() + "}";
    }
}

public class ArrayOfGenericReference {
    static Generic<Integer>[] gia;

    public static void main(String[] args) {
        gia = new Generic[10];
        gia[0] = new Generic<>(10);
        System.out.println(gia[0]);
    }
}

@SuppressWarnings("all") // 压制警告
class Generic2<T> {
    private Object[] array;

    public void f1() {
        // 创建一个 Object 数组，然后强制类型转换
        array = new Object[20];
    }

    public T get(int index) {
        return (T) array[index];
    }

}
