package tij.chapter15;

public class Finally {
    public static void main(String[] args) {
        try {
            System.out.println("before return");
            return;
        } finally {
            System.out.println("finally");
        }
    }
}
