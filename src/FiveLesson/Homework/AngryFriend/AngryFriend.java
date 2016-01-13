package FiveLesson.Homework.AngryFriend;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;

public class AngryFriend {

    private final int diametr = 100;


    public AngryFriend() {

    }

    public void myFrame() {
        JFrame frame = new JFrame("Angry friend");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);


        Panel panel = new Panel();

        panel.setBackground(Color.BLACK);


        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if ((e.getX() > panel.getCircle().getX() && e.getX() < panel.getCircle().getX() + diametr) && (e.getY() > panel.getCircle().getY() && e.getY() < panel.getCircle().getY() + diametr)) {
                    Random random = new Random();
                    panel.setCircle(new Circle(random.nextInt(500), random.nextInt(500), panel.getCircle().getWight(), panel.getCircle().getHeight()));
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                if ((e.getX() > panel.getCircle().getX() && e.getX() < panel.getCircle().getX() + diametr) && (e.getY() > panel.getCircle().getY() && e.getY() < panel.getCircle().getY() + diametr)) {
                    Random random = new Random();
                    panel.setCircle(new Circle(random.nextInt(500), random.nextInt(500), panel.getCircle().getWight(), panel.getCircle().getHeight()));
                }
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
