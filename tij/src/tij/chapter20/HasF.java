package tij.chapter20;

import java.util.ArrayList;

public class HasF {
    public void f() {
        System.out.println("HasF.f()");
    }
}

class Manipulator<T extends HasF> {
    private T obj;

    public Manipulator(T obj) {
        this.obj = obj;
    }

    public void manipulate() {
        obj.f();
    }

    public static void main(String[] args) {
        Manipulator<HasF> hasFManipulator = new Manipulator<>(new HasF());
        hasFManipulator.manipulate();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.get(0);
    }
}
