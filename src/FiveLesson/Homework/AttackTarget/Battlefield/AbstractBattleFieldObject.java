package FiveLesson.Homework.AttackTarget.Battlefield;

import FiveLesson.Homework.AttackTarget.Action.Destroyable;
import FiveLesson.Homework.AttackTarget.Action.Drawable;

import java.awt.*;

public abstract class AbstractBattleFieldObject implements Drawable, Destroyable {

    private int x;
    private int y;
    private boolean isDestroyed = false;

    public AbstractBattleFieldObject() {

    }

    public AbstractBattleFieldObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void destroy() {
        setX(-100);
        setY(-100);
        isDestroyed = true;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    @Override
    public void draw(Graphics graphics) {

    }
}

