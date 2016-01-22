package FiveLesson.Homework.AttackTarget.Battlefield;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Rock extends AbstractBattleFieldObject {

    private final String IMAGE_NAME = "ROCK.JPG";
    private Image rock;

    public Rock() {

    }

    public Rock(int x, int y) {
        super(x, y);
        try {
            rock = ImageIO.read(new File(IMAGE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(rock, getX(), getY(), new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
    }
}
