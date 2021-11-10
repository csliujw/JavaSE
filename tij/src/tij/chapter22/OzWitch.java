package tij.chapter22;

/**
 * 带有详细信息的枚举
 */
public enum OzWitch {
    WEST("This is WEST"),
    NORTH("This is NORTH"),
    EAST("This is EAST");

    private String desc;

    OzWitch(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public static void main(String[] args) {
        for (OzWitch value : OzWitch.values()) {
            System.out.println(value + ":" + value.getDesc());
        }
    }
}
