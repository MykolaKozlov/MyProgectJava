package ThirdLesson.Chapter_3_Task_2;

import javax.swing.*;
import java.awt.*;

public class ShapesTemplate extends JPanel {

    private AbstractShape[] abstractShapes;

    public ShapesTemplate(AbstractShape[] abstractShapes) {
        this.abstractShapes = abstractShapes;
        if (abstractShapes == null || abstractShapes.length < 1) {
            this.abstractShapes = new AbstractShape[0];
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
        for (AbstractShape s : abstractShapes) {
            s.draw(g);
        }
    }
}