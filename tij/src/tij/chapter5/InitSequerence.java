package tij.chapter5;

public class InitSequerence {
    Windows w1 = new Windows("w1");

    public InitSequerence() {
        Windows w2 = new Windows("w2");
    }

    Windows w3 = new Windows("w3");

    public static void main(String[] args) {
        new InitSequerence();
    }

    static class Windows {
        public Windows(String name) {
            System.out.println(name);
        }
    }
}
