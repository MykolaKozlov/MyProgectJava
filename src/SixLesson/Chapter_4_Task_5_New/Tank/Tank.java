package SixLesson.Chapter_4_Task_5_New.Tank;

import SixLesson.Chapter_4_Task_5_New.Action.Destroyable;
import SixLesson.Chapter_4_Task_5_New.Action.Direction;
import SixLesson.Chapter_4_Task_5_New.Action.Drawable;

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
