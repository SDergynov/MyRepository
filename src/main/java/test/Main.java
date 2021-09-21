package test;

/**
 * @author S.Dergunov sdergynov@gmail.com
 * "Keep it simply stupid!"
 */

public class Main {

    public static void main(String[] args) {
        FactoryShape factoryShape = new FactoryShape();
        Shape shape = factoryShape.factoryOfShapes(ShapeType.CUBE);
        shape.draw();
        Cube cube = (Cube) factoryShape.factoryOfShapes(ShapeType.CUBE);
        System.out.println(cube.equals(shape));
        System.out.println(cube);
        System.out.println(shape);

    }
}
