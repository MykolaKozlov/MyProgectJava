package FiveLesson.Chapter_2_Task_2;

import javax.swing.*;
import java.awt.*;

public class Window extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        g.drawString("MY FIRST TEXT", 100, 100);
    }

    public void drow() {
        JFrame jFrame = new JFrame("Window");
        jFrame.getContentPane().add(this);
        jFrame.setBounds(300, 100, 800, 600);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
