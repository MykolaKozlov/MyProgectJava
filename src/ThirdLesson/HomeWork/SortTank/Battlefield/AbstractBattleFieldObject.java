package ThirdLesson.HomeWork.SortTank.Battlefield;

import ThirdLesson.HomeWork.SortTank.Actions.Destroyable;
import ThirdLesson.HomeWork.SortTank.Actions.Drawable;

import java.awt.*;

public abstract class AbstractBattleFieldObject implements Drawable, Destroyable {

    private int x;
    private int y;

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

    }

    @Override
    public void draw(Graphics graphics) {

    }
}

