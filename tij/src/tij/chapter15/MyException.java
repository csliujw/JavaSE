package tij.chapter15;

public class MyException extends Exception {
    MyException() {
    }

    MyException(String msg) {
        super(msg);
    }


}

class TestMyException {
    public void f() throws MyException {
        throw new MyException("This is MyException");
    }

    public static void main(String[] args) {
        TestMyException exc = new TestMyException();
        try {
            exc.f();
        } catch (MyException e) {
            e.printStackTrace(System.err);
        }
    }
}