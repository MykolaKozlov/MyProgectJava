package ThirdLesson.Chapter_3_Task_5;

import javax.swing.*;
import java.awt.*;

public class ShapesTemplate extends JPanel {

    private Drawable[] drawables;

    public ShapesTemplate(Drawable[] drawables) {
        this.drawables = drawables;
        if (drawables == null || drawables.length < 1) {
            this.drawables = new Drawable[0];
        }

        JFrame frame = new JFrame("DAY 6, 2D Graphics");
        frame.setLocation(750, 150);
        frame.setMinimumSize(new Dimension(600, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        for (Drawable s : drawables) {
            s.draw(g);
        }
    }
}