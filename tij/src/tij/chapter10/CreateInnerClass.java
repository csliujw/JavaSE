package tij.chapter10;

public class CreateInnerClass {
    class InnerClass {
        public void innerSay() {
            System.out.println("I am inner class");
        }
    }

    public void say() {
        new InnerClass().innerSay();
    }

    public InnerClass getInnerClass() {
        return new InnerClass();
    }
}

class Main {
    public static void main(String[] args) {
        CreateInnerClass.InnerClass innerClass = new CreateInnerClass().getInnerClass();
    }
}
