package video.generic;

/**
 * 泛型
 * 相同类的不同泛型 他们的字节码对象是一致的，因为都是从同一个字节码对象出来的。
 * 泛型到字节码层面最终会变为Object对象，为int double不属于基本类型，所以没有
 * int这种泛型，只能用包装类
 */
public class Generic1 {
    public static void main(String[] args) {
        Generic<String> stringGeneric = new Generic<>();
        Generic<Integer> integerGeneric = new Generic<>();
        System.out.println(stringGeneric.getClass() == integerGeneric.getClass());
    }
}

class Generic<T> {
    private T data;

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }
}
