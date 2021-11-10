package tij.chapter23.format;

public class ContainerDemo {

    public static void usingSimpleContainer() {
        ServiceA a = SimpleContainer.getInstance(ServiceA.class);
        a.callB();

        ServiceB b = SimpleContainer.getInstance(ServiceB.class);

        if (b == a.getB()) {
            System.out.println("SimpleContainer2: same instances");
        }
    }

    public static void main(String[] args) {
        usingSimpleContainer();
    }
}
