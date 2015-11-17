package ThirdLesson.Chapter_2_Task_6;

import java.awt.*;

public class Circle extends Shape {

    public Circle() {
        System.out.println("Circle");
    }

    @Override
    public void draw(Graphics graphics) {
        Color old = graphics.getColor();
        Color color = new Color(0, 255, 0);
        graphics.setColor(color);
        graphics.fillOval(150, 25, 100, 100);
    }
}
