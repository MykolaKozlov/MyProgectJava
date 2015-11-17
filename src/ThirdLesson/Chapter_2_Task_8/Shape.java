package ThirdLesson.Chapter_2_Task_8;

import java.awt.*;

public class Shape {
    public Shape() {
        System.out.println("Shape");
    }

    public void draw(Graphics graphics) {
        throw new IllegalStateException("I don't know how to paint this shape. Please override me!");
    }
}
