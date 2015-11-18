package ThirdLesson.Chapter_3_Task_5;

import java.awt.*;

public class Triangle extends AbstractShape {
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
        Graphics2D graphics2D = (Graphics2D)graphics;
        graphics2D.setStroke(new BasicStroke(10));
        int x2[] = {125, 25, 25, 100, 100};
        int y2[] = {175, 175, 300, 100, 100};
        graphics.drawPolygon(x2, y2, 3);
    }
}
