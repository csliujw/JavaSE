package tij.chapter20;

class Building {
}

class House extends Building {
}

public class ClassTypeCapture<T> {
    Class<T> kind;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public static void main(String[] args) {
        ClassTypeCapture<House> b = new ClassTypeCapture<>(House.class);
        System.out.println(b.f(new Building()));
        System.out.println(b.f(new House()));
    }
}
