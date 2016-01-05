package FiveLesson.Chapter_1_Task_8;

import javax.swing.*;
import java.awt.*;

public class Window extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
//        g.setColor(Color.BLUE);
//        g.fillRect(0, 0, 800, 600);
    }

    public void drow() {
        JFrame jFrame = new JFrame("Window");
        jFrame.getContentPane().add(this);
        jFrame.setBackground(Color.BLUE);
        jFrame.setBounds(300, 100, 800, 600);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
