package tij.chapter5;

public enum SpicinessEnum {
    NOT, MILD, MEDIUM, HOT, FLAMING
}

class SimpleUseEnum {
    public static void main(String[] args) {
        for (SpicinessEnum value : SpicinessEnum.values()) {
            System.out.println(value + ":" + value.ordinal());
        }
    }
}
