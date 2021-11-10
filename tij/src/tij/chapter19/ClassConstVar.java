package tij.chapter19;

class ConstTest {
    public static final int NUMBER = 10;
}


public class ClassConstVar {
    public static void main(String[] args) {
        int n = ConstTest.NUMBER;
    }

    private class D {

    }
}