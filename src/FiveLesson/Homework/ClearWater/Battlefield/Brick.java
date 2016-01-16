package FiveLesson.Homework.ClearWater.Battlefield;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Brick extends AbstractBattleFieldObject {

    private final String IMAGE_NAME = "BRICK.JPG";
    private Image brick;


    public Brick(int x, int y) {
        super(x, y);
        try {
            brick = ImageIO.read(new File(IMAGE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Brick() {

    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(brick, getX(), getY(), new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
    }
}
