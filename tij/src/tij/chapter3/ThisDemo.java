package tij.chapter3;

public class ThisDemo {
    ThisDemo(){}
    ThisDemo(int ignore){}

    ThisDemo(short ignore){
        this();
    }
}
