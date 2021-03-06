package ThirdLesson.Chapter_3_Task_2;

import java.awt.*;

public class Rectangle extends AbstractShape {
    public Rectangle() {
        System.out.println("Rectangle");
    }

    @Override
    public void draw(Graphics graphics) {
        Color old = graphics.getColor();
        Color color = new Color(255, 255, 0);
        graphics.setColor(color);
        graphics.fillRect(300, 25, 150, 100);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setStroke(new BasicStroke(10));
        graphics.drawRect(300, 150, 150, 100);
    }
}
