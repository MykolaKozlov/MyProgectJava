package FiveLesson.Chapter_4_Task_9_TankImage.Tank;

import FiveLesson.Chapter_4_Task_9_TankImage.Action.Destroyable;
import FiveLesson.Chapter_4_Task_9_TankImage.Action.Direction;
import FiveLesson.Chapter_4_Task_9_TankImage.Action.Drawable;

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

    public Action moveToQuadrant(int v, int h);

}
