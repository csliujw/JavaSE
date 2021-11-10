package tij.chapter12;

public class MethodReferences {
    static void hello(String name) { // [3]
        System.out.println("Hello, " + name);
    }

    static class Description {
        String about;

        Description(String desc) {
            about = desc;
        }

        void help(String msg) { // [4]
            System.out.println(about + " " + msg);
        }
    }

    static class Helper {
        static void assist(String msg) { // [5]
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        Describe d = new Describe(); // 外部类的非静态方法
        Callable c = d::show; // [6]
        c.call("call()"); // [7]
        c = MethodReferences::hello; // [8]  本类的静态方法
        c.call("Bob");
        c = new Description("valuable")::help; // [9] 静态内部类的非静态方法
        c.call("information");
        c = Helper::assist; // [10]
        c.call("Help!");
    }
}

interface Callable { // [1]
    void call(String s);
}

class Describe {
    void show(String msg) { // [2]
        System.out.println(msg);
    }
}
