package video.classloader;

public class ClassLoaderTest {
    public static String loaderStaticFunction() {
        return "Hello World Static Function";
    }

    public void loaderSay() {
        System.out.println("loader say");
    }

    public void loaderSleep() {
        System.out.println("loader sleep");
    }

    public String loaderString() {
        return "Hello World Java";
    }
}
