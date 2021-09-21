package test;

/**
 * @author S.Dergunov sdergynov@gmail.com
 * "Keep it simply stupid!"
 */

public class FactoryShape {
    public Shape factoryOfShapes(ShapeType shapeType){
        switch (shapeType){
            case CUBE:return new Cube();
            case TRIANGLE:return new Triangle();
        }
        return shapeType.getShape();
    }
}
