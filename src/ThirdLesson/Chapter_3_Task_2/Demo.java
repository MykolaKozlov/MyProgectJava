package ThirdLesson.Chapter_3_Task_2;

public class Demo {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        Triangle triangle = new Triangle();
        Square square = new Square();
        AbstractShape[] abstractShapes = new AbstractShape[4];
        abstractShapes[0] = circle;
        abstractShapes[1] = triangle;
        abstractShapes[2] = rectangle;
        abstractShapes[3] = square;
        ShapesTemplate shapesTemplate = new ShapesTemplate(abstractShapes);
    }
}
