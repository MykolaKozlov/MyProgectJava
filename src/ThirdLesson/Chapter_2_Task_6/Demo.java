package ThirdLesson.Chapter_2_Task_6;

public class Demo {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        Triangle triangle = new Triangle();
        Shape[] shapes = new Shape[3];
        shapes[0] = circle;
        shapes[1] = triangle;
        shapes[2] = rectangle;
        ShapesTemplate shapesTemplate = new ShapesTemplate(shapes);
    }
}
