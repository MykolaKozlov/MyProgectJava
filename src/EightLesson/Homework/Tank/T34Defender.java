package EightLesson.Homework.Tank;

import EightLesson.Homework.Action.Direction;
import EightLesson.Homework.Battlefield.BattleField;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class T34Defender extends AbstractTank {

    private Image[] defender = new Image[4];

    public T34Defender(BattleField battleField) {
        super(battleField);
    }

    public T34Defender(int x, int y, Direction direction, BattleField battleField) {
        super(x, y, direction, battleField);
        try {
            defender[0] = ImageIO.read(new File("DEFENDER_TOP.png"));
            defender[1] = ImageIO.read(new File("DEFENDER_BOTTOM.png"));
            defender[2] = ImageIO.read(new File("DEFENDER_LEFT.png"));
            defender[3] = ImageIO.read(new File("DEFENDER_RIGHT.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isDestroyed() {
        return super.isDestroyed();
    }

    @Override
    public void turn(Direction direction) {
        super.turn(direction);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void draw(Graphics graphics) {
        if (this.getDirection() == Direction.UP) {
            graphics.drawImage(defender[0], getX(), getY(), new ImageObserver() {
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            });
        } else if (this.getDirection() == Direction.DOWN) {
            graphics.drawImage(defender[1], getX(), getY(), new ImageObserver() {
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            });
        } else if (this.getDirection() == Direction.LEFT) {
            graphics.drawImage(defender[2], getX(), getY(), new ImageObserver() {
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            });
        } else {
            graphics.drawImage(defender[3], getX(), getY(), new ImageObserver() {
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            });
        }
    }
}
