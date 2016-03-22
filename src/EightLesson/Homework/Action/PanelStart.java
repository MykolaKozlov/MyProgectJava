package EightLesson.Homework.Action;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class PanelStart extends JPanel {


    @Override
    protected void paintComponent(Graphics g) {
        setLocation(0, 0);
        setSize(700, 393);
        final String START_IMAGE = "StartPanelTankNew.jpg";
        Image background = null;
        try {
            background = ImageIO.read(new File(START_IMAGE));
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
