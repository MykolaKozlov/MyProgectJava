package ThirdLesson.HomeWork.SortTank.Tank;

import ThirdLesson.HomeWork.SortTank.Actions.Destroyable;
import ThirdLesson.HomeWork.SortTank.Actions.Direction;
import ThirdLesson.HomeWork.SortTank.Actions.Drawable;

import java.awt.*;

public class Bullet implements Destroyable, Drawable {
    private int x;
    private int y;
    private int speed = 5;
    private Direction direction;

    public Bullet(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
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

    public void updateX(int x) {
        this.x += x;
    }

    public void updateY(int y) {
        this.y += y;
    }

    public void destroy() {
        x = -100;
        y = -100;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(new Color(255, 255, 0));
        graphics.fillRect(this.getX(), this.getY(), 14, 14);
    }
}
