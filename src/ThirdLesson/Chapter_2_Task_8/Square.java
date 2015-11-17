package ThirdLesson.Chapter_2_Task_8;

import java.awt.*;

public class Square extends Rectangle {
    public Square(){
        System.out.println("Square");
    }

    @Override
    public void draw(Graphics graphics) {
        Color old = graphics.getColor();
        Color color = new Color(50, 50, 150);
        graphics.setColor(color);
        graphics.fillRect(500, 25, 100, 100);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setStroke(new BasicStroke(5));
        graphics.drawRect(500, 150, 100, 100);
    }
}
