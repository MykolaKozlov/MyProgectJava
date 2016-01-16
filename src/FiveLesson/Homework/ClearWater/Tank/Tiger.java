package FiveLesson.Homework.ClearWater.Tank;

import FiveLesson.Homework.ClearWater.Action.Direction;
import FiveLesson.Homework.ClearWater.Battlefield.BattleField;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Tiger extends AbstractTank {
    protected int armor;
    private Image[] agressor = new Image[4];

    public Tiger(int x, int y, Direction direction, BattleField battleField, int armor) {
        super(x, y, direction, battleField);
        this.armor = armor;
        try {
            agressor[0] = ImageIO.read(new File("AGRESSOR_TOP.png"));
            agressor[1] = ImageIO.read(new File("AGRESSOR_BOTTOM.png"));
            agressor[2] = ImageIO.read(new File("AGRESSOR_LEFT.png"));
            agressor[3] = ImageIO.read(new File("AGRESSOR_RIGHT.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isDestroyed() {
        return super.isDestroyed();
    }

    @Override
    public void destroy() {
        if (armor == 0) {
            super.destroy();
        }
        armor--;
    }

    @Override
    public void turn(Direction direction) {
        super.turn(direction);
    }

    @Override
    public void draw(Graphics graphics) {
        if (this.getDirection() == Direction.UP) {
            graphics.drawImage(agressor[0], getX(), getY(), new ImageObserver() {
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            });
        } else if (this.getDirection() == Direction.DOWN) {
            graphics.drawImage(agressor[1], getX(), getY(), new ImageObserver() {
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            });
        } else if (this.getDirection() == Direction.LEFT) {
            graphics.drawImage(agressor[2], getX(), getY(), new ImageObserver() {
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            });
        } else {
            graphics.drawImage(agressor[3], getX(), getY(), new ImageObserver() {
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            });
        }
    }
}
