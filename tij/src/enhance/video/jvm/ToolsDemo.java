package video.jvm;

public class ToolsDemo {
    public static void main(String[] args) {
        assert 1 == 1;
        System.out.println("A Go!");
        System.out.println("\n-----------------------------------------------\n");
        assert 1 != 1 : "Wrong";
        System.out.println("B Go!");
    }
}
