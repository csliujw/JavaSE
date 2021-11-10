package video.generic;

import java.lang.reflect.Field;

/**
 * 类型擦除猜想验证。
 */
public class Erasure<T> {

    public static void main(String[] args) {
        Erasure1<String> erasure1 = new Erasure1<>();
        Class<? extends Erasure1> aClass = erasure1.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(String.format("key=%s === type=%s", field.getName(), field.getType().getSimpleName()));
        }

        Erasure2<Integer> erasure2 = new Erasure2<>();
        Class<? extends Erasure2> aClass2 = erasure2.getClass();
        Field[] fields2 = aClass2.getDeclaredFields();
        for (Field field : fields2) {
            System.out.println(String.format("key=%s === type=%s", field.getName(), field.getType().getSimpleName()));
        }

        // 泛型方法的擦除和类泛型的擦除一样。
    }

}

// 泛型擦除改成了Object
class Erasure1<T> {
    private T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }
}
// 泛型擦除改成了上限类型Number
class Erasure2<T extends Number> {
    private T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }
}
