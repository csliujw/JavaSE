package tij.chapter20;


class Automobile { }

// 非泛型，限定了取值的类型
public class Hold {
    private Automobile a;

    public Hold(Automobile a) {
        this.a = a;
    }

    Automobile get() {
        return a;
    }
}
