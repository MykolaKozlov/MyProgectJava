package EightLesson.Homework.Tank;

import EightLesson.Homework.Action.Destroyable;
import EightLesson.Homework.Action.Direction;
import EightLesson.Homework.Action.Drawable;

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
