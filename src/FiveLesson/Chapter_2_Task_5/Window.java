package FiveLesson.Chapter_2_Task_5;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Window extends JPanel {

    private final String IMAGE_NAME = "TANK.png";
    private Image tank;

    public Window (){
        try {
            tank = ImageIO.read(new File(IMAGE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect(0, 0, 800, 600);
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.BOLD, 30));
        g.drawString("TANK_GAME", 100, 100);
        g.drawImage(tank, 200, 200, new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });

    }

    public void drow() {
        JFrame jFrame = new JFrame("Window");
        jFrame.getContentPane().add(this);
        jFrame.setBounds(300, 100, 800, 600);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
