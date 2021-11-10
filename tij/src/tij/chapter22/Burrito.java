package tij.chapter22;

public class Burrito {
    Spiciness degree;

    public Burrito(Spiciness degree) {
        this.degree = degree;
    }

    public void describe() {
        System.out.println("This burrito is ");
        switch (degree) {
            case NOT:
                System.out.println("not spicy at all");
                break;
            case MEDIUM:
                System.out.println("a little hot");
                break;
            default:
                System.out.println("too hot");
        }
    }

    public static void main(String[] args) {
        Burrito plain = new Burrito(Spiciness.NOT);
        Burrito greenChile = new Burrito(Spiciness.MEDIUM);
        plain.describe();
        greenChile.describe();
    }
}
