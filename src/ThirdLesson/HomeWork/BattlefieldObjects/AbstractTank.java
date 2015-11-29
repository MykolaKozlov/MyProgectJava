package ThirdLesson.HomeWork.BattlefieldObjects;

import java.awt.*;

public abstract class AbstractTank implements Drawable, Destroyable {
    protected int speed = 10;
    protected int x;
    protected int y;
    protected Direction direction;
    protected ActionField actionField;
    protected BattleField battleField;

    public AbstractTank(ActionField actionField, BattleField battleField) {
        this(0, 512, Direction.UP, actionField, battleField);
    }

    public AbstractTank(int x, int y, Direction direction, ActionField actionField,
                        BattleField battleField) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.actionField = actionField;
        this.battleField = battleField;
    }

    public void updateX(int x) {
        this.x += x;
    }

    public void updateY(int y) {
        this.y += y;
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

    public ActionField getActionField() {
        return actionField;
    }

    public BattleField getBattleField() {
        return battleField;
    }

    public void turn(Direction direction) throws Exception {
        this.direction = direction;
        actionField.processTurn(this);
    }

    public void move() throws Exception {
        actionField.processMove(this);
    }


    public void fire() throws Exception {
        Bullet bullet = new Bullet(x + 25, y + 25, direction);
        actionField.processFire(bullet);
    }

    public int random() {
        int rand = 0;
        int[] array = {1, 2, 3, 4};
        long time = System.currentTimeMillis();
        String str = Long.toString(time);
        char lostSimbol = str.charAt(str.length() - 1);
        int lost = Integer.parseInt(String.valueOf(lostSimbol));
        if (lost >= 6 && lost <= 7) {
            rand = array[0];
        }
        if (lost >= 3 && lost <= 5) {
            rand = array[1];
        }
        if (lost >= 0 && lost <= 2) {
            rand = array[2];
        }
        if (lost >= 8 && lost <= 9) {
            rand = array[3];
        }
        return rand;
    }

    public void destroy() {
        x = -100;
        y = -100;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(new Color(0, 0, 0));
        graphics.fillRect(this.getX(), this.getY(), 64, 64);

        graphics.setColor(new Color(0, 255, 0));
        if (this.getDirection() == Direction.UP) {
            graphics.fillRect(this.getX() + 20, this.getY(), 24, 34);
        } else if (this.getDirection() == Direction.DOWN) {
            graphics.fillRect(this.getX() + 20, this.getY() + 30, 24, 34);
        } else if (this.getDirection() == Direction.LEFT) {
            graphics.fillRect(this.getX(), this.getY() + 20, 34, 24);
        } else {
            graphics.fillRect(this.getX() + 30, this.getY() + 20, 34, 24);
        }
    }
}
