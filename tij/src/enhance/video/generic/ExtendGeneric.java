package video.generic;

/**
 * 泛型的继承
 * 子类也是泛型，子类和父类的泛型类型要一致
 * 父类型不声明的话，默认是object类型
 * 子类不是泛型，父类要明确泛型的数据类型
 */
public class ExtendGeneric {
    public static void main(String[] args) {
        ChildSecond childSecond = new ChildSecond();
        // System.out.println(childSecond.getClass()); //class org.example.video.generic.ChildSecond
        childSecond.setValue(100);
        System.out.println(childSecond.getValue());
    }
}

class ChildSecond extends Parent<Integer> {
    @Override
    public Integer getValue() {
        return super.getValue();
    }
}

class Child<T> extends Parent {

    // 写T的话会报错
    @Override
    public Object getValue() {
        return super.getValue();
    }
}

class Parent<T> {
    private T value;

    public void setValue(T value) {
        this.value = value;
    }


    public T getValue() {
        return value;
    }

}
