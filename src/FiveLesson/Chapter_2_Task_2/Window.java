package FiveLesson.Chapter_2_Task_2;

import javax.swing.*;
import java.awt.*;

public class Window extends JPanel {

    public void drow() {
        JFrame jFrame = new JFrame("Window");
        JLabel jLabel = new JLabel("Text");
        jFrame.getContentPane().add(this);
        jFrame.setBounds(300, 100, 800, 600);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jLabel.setFont(new Font("dsfgsdfgs", Font.ROMAN_BASELINE, 100));
        jFrame.setVisible(true);



    }
}
