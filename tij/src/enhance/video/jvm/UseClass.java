package video.jvm;

/**
 * 主动使用类 测试
 */
class Demo{
    static {
        System.out.println("inti a");
    }
}
public class UseClass {

    public static void main(String[] args) throws ClassNotFoundException {
        // Demo1.class; // 不是主动使用~~
        // 主动使用
        Class<?> aClass = Class.forName("org.example.video.jvm.Demo1");

    }
}
