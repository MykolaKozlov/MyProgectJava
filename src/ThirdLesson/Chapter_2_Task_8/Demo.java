package ThirdLesson.Chapter_2_Task_8;

public class Demo {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        Triangle triangle = new Triangle();
        Square square = new Square();
        Shape[] shapes = new Shape[4];
        shapes[0] = circle;
        shapes[1] = triangle;
        shapes[2] = rectangle;
        shapes[3] = square;
        ShapesTemplate shapesTemplate = new ShapesTemplate(shapes);
    }
}
