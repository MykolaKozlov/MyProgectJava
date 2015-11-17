package ThirdLesson.Chapter_2_Task_6;

import java.awt.*;

public class Rectangle extends Shape {
    public Rectangle() {
        System.out.println("Rectangle");
    }

    @Override
    public void draw(Graphics graphics) {
        Color old = graphics.getColor();
        Color color = new Color(255, 255, 0);
        graphics.setColor(color);
        graphics.fillRect(300, 25, 100, 100);
    }
}
