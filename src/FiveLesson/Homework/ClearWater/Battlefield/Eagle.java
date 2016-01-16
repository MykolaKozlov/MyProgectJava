package FiveLesson.Homework.ClearWater.Battlefield;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Eagle extends AbstractBattleFieldObject {

    private final String IMAGE_NAME = "EAGLE.png";
    private Image eagle;

    public Eagle() {

    }

    public Eagle(int x, int y) {
        super(x, y);
        try {
            eagle = ImageIO.read(new File(IMAGE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(eagle, getX(), getY(), new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
    }
}
