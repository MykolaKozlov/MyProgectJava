package FiveLesson.Chapter_4_Task_9_TankImage.Battlefield;

import FiveLesson.Chapter_4_Task_9_TankImage.Action.Destroyable;
import FiveLesson.Chapter_4_Task_9_TankImage.Action.Drawable;

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

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }
}

