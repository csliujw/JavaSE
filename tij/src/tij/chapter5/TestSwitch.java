package tij.chapter5;

public class TestSwitch {
    public static void main(String[] args) {
        String str = "dd";
        switch (str) {
            case "dd":
                System.out.println("odk");
                break;
            case "cc":
            default:
                System.out.println("over!");
        }
    }
}
