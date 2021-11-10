package tij.chapter12;

class Dog {
    String name;
    int age = -1; // For "unknown"

    Dog() {
        name = "stray";
    }

    Dog(String nm) {
        name = nm;
    }

    Dog(String nm, int yrs) {
        name = nm;
        age = yrs;
    }
}

interface MakeNoArgs {
    Dog make();
}

interface Make1Arg {
    Dog make(String nm);
}

interface Make2Args {
    Dog make(String nm, int age);
}


public class CtorReference {
    public static void main(String[] args) {
        MakeNoArgs mna = Dog::new; // [1]  构造函数引用赋值过去
        Make1Arg m1a = Dog::new; // [2] 构造函数引用赋值过去
        Make2Args m2a = Dog::new; // [3] 构造函数引用赋值过去
        Dog dn = mna.make(); // 调用make，make调用构造函数实例化对象
        Dog d1 = m1a.make("Comet");
        Dog d2 = m2a.make("Ralph", 4);
        System.out.println(dn);
        System.out.println(d1);
        System.out.println(d2);
    }
}
