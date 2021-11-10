package tij.chapter5;

public class GoToDemo {
    public static void main(String[] args) {
        outer:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 5) {
                    System.out.println(j);
                    break outer;
                }
            }
        }
    }
}
