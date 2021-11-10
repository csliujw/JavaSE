package tij.chapter22;

//创建了一个名为 Spiciness 的枚举类型
// PS: 枚举实例为常量
public enum Spiciness {
    NOT, MIL, MEDIUM, HOT, FLAMING
}

class SimpleEnumUse {
    public static void main(String[] args) {
        Spiciness hot = Spiciness.HOT;
        System.out.println(hot); // HOT
        System.out.println("=====================");
        for (Spiciness value : Spiciness.values()) {
            System.out.println(value + ",ordinal " + value.ordinal());
        }
    }
}