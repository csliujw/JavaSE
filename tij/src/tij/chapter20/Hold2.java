package tij.chapter20;


public class Hold2<T> {
    private T a;

    public Hold2(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }

    public static void main(String[] args) {
        String string = new String("123");
        Hold2<String> hold = new Hold2<>(string);
        System.out.println(hold.get());
    }
}
