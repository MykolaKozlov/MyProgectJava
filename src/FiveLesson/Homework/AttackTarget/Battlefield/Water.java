package FiveLesson.Homework.AttackTarget.Battlefield;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Water extends AbstractBattleFieldObject {

    private final String IMAGE_NAME = "WATER.JPG";
    private Image water;

    public Water() {

    }

    public Water(int x, int y) {
        super(x, y);
        try {
            water = ImageIO.read(new File(IMAGE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics graphics) {
        Graphics2D g2D = (Graphics2D) graphics;
        Composite composite = g2D.getComposite();
        g2D.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, 0.3f));
        graphics.drawImage(water, getX(), getY(), new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
        g2D.setComposite(composite);
    }
}
