package test;

/**
 * @author S.Dergunov sdergynov@gmail.com
 * "Keep it simply stupid!"
 */
public enum ShapeType {
    TRIANGLE(new Triangle()), CUBE(new Cube());

    private final Shape shape;

    ShapeType(Shape shape) {
        this.shape = shape;
    }

    public Shape getShape(){
        return this.shape;
    }
}
