package tij.chapter22;

public enum ConstantSpecificMethod {
    CLASSPATH {
        @Override
        String getInfo() {
            return System.getProperty("CLASSPATH");
        }
    },
    VERSION {
        @Override
        String getInfo() {
            return System.getProperty("java.version");
        }
    };

    abstract String getInfo();

    public static void main(String[] args) {
        for (ConstantSpecificMethod value : ConstantSpecificMethod.values()) {
            System.out.println(value + ", getInfo=" + value.getInfo());
        }
    }
}
