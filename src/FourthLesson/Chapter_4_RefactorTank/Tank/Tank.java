package FourthLesson.Chapter_4_RefactorTank.Tank;

import FourthLesson.Chapter_4_RefactorTank.Action.Destroyable;
import FourthLesson.Chapter_4_RefactorTank.Action.Direction;
import FourthLesson.Chapter_4_RefactorTank.Action.Drawable;

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
