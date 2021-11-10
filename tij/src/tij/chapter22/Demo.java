package tij.chapter22;

public enum Demo {
    ONE, TWO, THREE;

    public static void main(String[] args) {
        System.out.println();
        for (Demo d : Demo.values()) {
            System.out.println(d);
        }
    }
}