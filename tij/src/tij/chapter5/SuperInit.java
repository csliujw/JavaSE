package tij.chapter5;

// 父类初始化的顺序
public class SuperInit {
    public static void main(String[] args) {
        new Cartoon();
    }
}

class Art {
    public Art() {
        System.out.println("Art");
    }
}

class Drawing extends Art {
    public Drawing() {
        System.out.println("Drawing");
    }
}

class Cartoon extends Drawing {
    public Cartoon() {
        System.out.println("Cartoon");
    }
}