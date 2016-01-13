package FiveLesson.Homework.AngryFriend;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    private Circle circle;

    public Panel() {
        circle = new Circle(100, 100, 100, 100);
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(Color.cyan);
        graphics2D.fill(circle);
        graphics2D.setColor(Color.RED);
        graphics2D.drawString("CLICK ME", (int)circle.getX() + 20, (int)circle.getY() + 55);
        repaint();
    }
}
