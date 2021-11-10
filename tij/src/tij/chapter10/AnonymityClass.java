package tij.chapter10;

public class AnonymityClass {

    public Contents contents() {
        return new Contents() {
            @Override
            public void values() {
                System.out.println(123);
            }
        };
    }

    public static void main(String[] args) {
        AnonymityClass anonymityClass = new AnonymityClass();
        anonymityClass.contents().values();
    }
}
