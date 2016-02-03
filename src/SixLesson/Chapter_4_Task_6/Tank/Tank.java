package SixLesson.Chapter_4_Task_6.Tank;

import SixLesson.Chapter_4_Task_6.Action.Destroyable;
import SixLesson.Chapter_4_Task_6.Action.Direction;
import SixLesson.Chapter_4_Task_6.Action.Drawable;

public interface Tank extends Destroyable, Drawable {

    public Action setUp();

    public void turn(Direction direction);

    public void move();

    public Bullet fire();

    public int getX();

    public int getY();

    public Direction getDirection();

    public void updateX(int x);

    public void updateY(int y);

    public int getSpeed();

    public boolean isDestroyed();

}
