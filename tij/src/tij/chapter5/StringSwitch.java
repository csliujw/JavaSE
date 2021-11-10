package tij.chapter5;

public class StringSwitch {
    public static void main(String[] args) {
        String color = "red";
        // 老的方式: 使用 if-then 判断
        if ("red".equals(color)) {
            System.out.println("RED");
        } else if ("green".equals(color)) {
            System.out.println("GREEN");
        } else if ("blue".equals(color)) {
            System.out.println("BLUE");
        } else if ("yellow".equals(color)) {
            System.out.println("YELLOW");
        } else {
            System.out.println("Unknown");
        }
        // 新的方法: 字符串搭配 switch
        switch (color) {
            case "red":
                System.out.println("RED");
                break;
            case "green":
                System.out.println("GREEN");
                break;
            case "blue":
                System.out.println("BLUE");
                break;
            case "yellow":
                System.out.println("YELLOW");
                break;
            default:
                System.out.println("Unknown");
                break;
        }
    }
}
