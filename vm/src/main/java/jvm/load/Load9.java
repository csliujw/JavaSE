package jvm.load;

public class Load9 {
    public static void main(String[] args) {
        // 单纯调用这个方法，不会触发 INSTANCE 的初始化，因为是懒加载，用到是才初始化。
        // Singleton.test();
        // 第一次用到了，所以会触发 加载 链接 初始化
        Singleton.getInstance();

    }
}

class Singleton {
    public static void test() {
        System.out.println("test");
    }

    private Singleton() {
    }

    private static class LazyHolder {
        private static final Singleton INSTNACE = new Singleton();

        static {
            System.out.println("LazyHolder init");
        }
    }

    public static Singleton getInstance() {
        return LazyHolder.INSTNACE;
    }
}
