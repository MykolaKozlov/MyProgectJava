package FourthLesson.HomeWork.AttackTank.Tank;

import FourthLesson.HomeWork.AttackTank.Action.Destroyable;
import FourthLesson.HomeWork.AttackTank.Action.Direction;
import FourthLesson.HomeWork.AttackTank.Action.Drawable;

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
