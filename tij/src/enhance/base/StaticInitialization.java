package enhance.base;
import static java.lang.System.out;
class Bowl {
    Bowl(int marker) {
        out.println("Bowl(" + marker + ")");
    }
    void f1(int marker) {
        out.println("f1(" + marker + ")");
    }
}

class Table {
    static Bowl bowl1 = new Bowl(1);
    Table() {
        out.println("Table()");
        bowl2.f1(1);
    }
    void f2(int marker) {
        out.println("f2(" + marker + ")");
    }
    static Bowl bowl2 = new Bowl(2);
}

class Cupboard {
    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);
    Cupboard() {
        out.println("Cupboard()");
        bowl4.f1(2);
    }
    void f3(int marker) {
        out.println("f3(" + marker + ")");
    }
    static Bowl bowl5 = new Bowl(5);
}

public class StaticInitialization {
    public static void main(String[] args) {
        out.println("Creating new Cupboard() in main");
        new Cupboard();
        out.println("Creating new Cupboard() in main");
        new Cupboard();
        table.f2(1);
        cupboard.f3(1);
    }
    static Table table = new Table(); // 先执行这个的初始化
    /**
     * "Bowl(" + 1 + ")"
     *      * "Bowl(" + 2 + ")"
     *      "Table()"
     *      f1(" + 1 + ")
     */
    static Cupboard cupboard = new Cupboard();
    /**
     * Bowl 4
     * Bowl 5
     * Bowl 3
     * Cupboard()
     * f12
     * Creating new Cupboard() in main
     *      * Bowl 3
     *      Cupboard
     *      f12
     *  Creating new Cupboard() in main
     *       *      * Bowl 3
     *      *      Cupboard
     *      *      f12
     */
}