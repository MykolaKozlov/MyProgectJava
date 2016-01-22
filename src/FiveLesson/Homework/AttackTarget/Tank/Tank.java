package FiveLesson.Homework.AttackTarget.Tank;

import FiveLesson.Homework.AttackTarget.Action.Destroyable;
import FiveLesson.Homework.AttackTarget.Action.Direction;
import FiveLesson.Homework.AttackTarget.Action.Drawable;

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
