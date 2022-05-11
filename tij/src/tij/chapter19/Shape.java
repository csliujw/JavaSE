package tij.chapter19;

import java.util.stream.Stream;

public abstract class Shape {
    public void draw() {
        System.out.println(this + " type");
    }

    @Override
    public abstract String toString();

    public static void main(String[] args) {
        Stream<Shape> shape = Stream.of(new Circle(), new Square(), new Triangle());
        shape.forEach(e->{
            if(e.getClass() == Triangle.class){
                System.out.println("I find Triangle. We can op it");
            }
        });
        System.out.println(int.class == Integer.TYPE);
    }
}

class Circle extends Shape {

    @Override
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {

    @Override
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape {

    @Override
    public String toString() {
        return "Triangle";
    }
}


