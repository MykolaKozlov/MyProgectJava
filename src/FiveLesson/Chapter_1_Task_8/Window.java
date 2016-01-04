package FiveLesson.Chapter_1_Task_8;

import javax.swing.*;
import java.awt.*;

public class Window extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
    }

    public void drow() {
        JFrame jFrame = new JFrame("Window");
        jFrame.setBounds(300, 100, 800, 600);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setBackground(Color.BLUE);
        jFrame.getContentPane().add(this);
        jFrame.setVisible(true);
    }
}
