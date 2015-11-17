package ThirdLesson.Chapter_2_Task_6;

import java.awt.*;

public class Triangle extends Shape {
    public Triangle() {
        System.out.println("Triangle");
    }

    @Override
    public void draw(Graphics graphics) {
        Color old = graphics.getColor();
        Color color = new Color(100, 10, 100);
        graphics.setColor(color);
        int xpoints[] = {25, 145, 25, 145, 25};
        int ypoints[] = {25, 25, 145, 145, 25};
        graphics.fillPolygon(xpoints, ypoints, 3);
    }
}
