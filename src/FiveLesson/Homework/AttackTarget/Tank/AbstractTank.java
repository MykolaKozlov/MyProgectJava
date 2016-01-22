package FiveLesson.Homework.AttackTarget.Tank;

import FiveLesson.Homework.AttackTarget.Action.Direction;
import FiveLesson.Homework.AttackTarget.Battlefield.BattleField;

import java.util.Random;

public abstract class AbstractTank implements Tank {
    protected int speed = 10;
    protected int x;
    protected int y;
    protected Direction direction;
    protected BattleField battleField;
    private boolean destroyed;

    public AbstractTank(BattleField battleField) {
        this(0, 512, Direction.UP, battleField);
    }

    public AbstractTank(int x, int y, Direction direction, BattleField battleField) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.battleField = battleField;
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

    public int getSpeed() {
        return speed;
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

    public BattleField getBattleField() {
        return battleField;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void turn(Direction direction) {
        this.direction = direction;
    }

    public void move() {
    }

    public Bullet fire() {
        int bulletX = -100;
        int bulletY = -100;
        if (direction == Direction.UP) {
            bulletX = x + 25;
            bulletY = y - 15;
        } else if (direction == Direction.DOWN) {
            bulletX = x + 25;
            bulletY = y + 64;
        } else if (direction == Direction.LEFT) {
            bulletX = x - 15;
            bulletY = y + 25;
        } else if (direction == Direction.RIGHT) {
            bulletX = x + 64;
            bulletY = y + 25;
        }
        return new Bullet(bulletX, bulletY, direction);
    }

    public void destroy() {
        x = -100;
        y = -100;
        destroyed = true;
    }

    public Action setUp() {
        Random random = new Random();
        return Action.values()[random.nextInt(6)];
    }

}
