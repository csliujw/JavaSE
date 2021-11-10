package tij.chapter12;

public class LambdaExpressions {
    static Body bod = h -> h + "No Parent!";
    static Body bod2 = (h) -> h + "More details!";
    static Description desc = () -> "Short info";
    static Multi mult = (h1, h2) -> h1 + h2;
    static Description moreLines = () -> {
        System.out.println("moreLines()");
        return "from moreLines";
    };

    public static void main(String[] args) {
        System.out.println(bod.detailed("Oh!"));
        System.out.println(bod2.detailed("Hi!"));
        System.out.println(desc.brief());
        System.out.println(mult.twoArg("Pi! ", 3.14159));
        System.out.println(moreLines.brief());
    }
}

interface Description {
    String brief();
}

interface Body {
    String detailed(String head);
}

interface Multi {
    String twoArg(String head, Double d);
}
