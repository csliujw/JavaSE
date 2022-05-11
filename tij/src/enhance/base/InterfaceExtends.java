package enhance.base;

interface Bob1{
    default void say(){
        System.out.println("Bob1::say");
    }
}

interface Bob2{
    default void say2(){
        System.out.println("Bob2::say");
    }
}
public class InterfaceExtends implements Bob1,Bob2{

    @Override
    public void say() {
        Bob1.super.say();
    }
}
