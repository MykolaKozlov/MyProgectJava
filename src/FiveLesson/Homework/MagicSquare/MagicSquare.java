package FiveLesson.Homework.MagicSquare;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MagicSquare {

    public MagicSquare() {

    }

    public void Square() {
        JFrame frame = new JFrame("Magic Square");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.setLocationRelativeTo(null);


        JPanel panel = new JPanel();


        JButton button = new JButton();
        button.setBackground(Color.BLACK);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                random.nextInt(100);
                button.setBackground(Color.getHSBColor(random.nextInt(100), random.nextInt(100), random.nextInt(100)));
            }
        });

        button.setPreferredSize(new Dimension(300, 300));


        panel.add(button);


        frame.add(panel);
        frame.setVisible(true);
    }
}
