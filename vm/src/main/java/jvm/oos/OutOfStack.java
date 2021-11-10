package jvm.oos;

/**
 * 栈溢出
 */
public class OutOfStack {
    private static int count = 0;

    public static void main(String[] args) {
        try {
            testStackOverFlowError();
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println(count);
        }
    }

    private static void testStackOverFlowError() {
        count++;
        testStackOverFlowError();
    }
}
