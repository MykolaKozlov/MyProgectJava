package EightLesson.Homework.Action;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class PanelEnd extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        setLocation(0, 0);
        final String END_IMAGE = "GameOver.png";
        Image background = null;
        try {
            background = ImageIO.read(new File(END_IMAGE));
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
