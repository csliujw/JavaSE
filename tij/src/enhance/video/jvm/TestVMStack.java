package video.jvm;

public class TestVMStack {
    public static void main(String[] args) {
        // Exception in thread "main" java.lang.StackOverflowError
        // 当方法太多时 就会发生 StackOverflowError
        main(new String[]{"1"});
    }
}
