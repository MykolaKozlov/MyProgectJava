package SixLesson.Chapter_4_Task_5_New.Tank;

import SixLesson.Chapter_4_Task_5_New.Action.Destroyable;
import SixLesson.Chapter_4_Task_5_New.Action.Direction;
import SixLesson.Chapter_4_Task_5_New.Action.Drawable;

import java.awt.*;

public class Bullet implements Destroyable, Drawable {
    private int x;
    private int y;
    private int speed = 5;
    private Direction direction;
    private boolean destroyed;

    public Bullet(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.destroyed = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void updateX(int x) {
        if (direction == Direction.RIGHT) {
            this.x += x;
        }
        if (direction == Direction.LEFT) {
            this.x -= x;
        }
    }

    public void updateY(int y) {
        if (direction == Direction.DOWN) {
            this.y += y;
        }
        if (direction == Direction.UP) {
            this.y -= y;
        }
    }

    public void destroy() {
        x = -100;
        y = -100;
        destroyed = true;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(new Color(255, 255, 0));
        graphics.fillRect(this.getX(), this.getY(), 14, 14);
    }
}
