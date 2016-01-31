package SixLesson.Chapter_4_Task_5_New.Action;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Panel extends JPanel {


    @Override
    protected void paintComponent(Graphics g) {
        setLocation(0, 0);
        setSize(700, 393);
        final String IMAGE_NAME = "StartPanelTankNew.jpg";
        Image background = null;
        try {
            background = ImageIO.read(new File(IMAGE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.drawImage(background, 0, 0, new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
    }
}
