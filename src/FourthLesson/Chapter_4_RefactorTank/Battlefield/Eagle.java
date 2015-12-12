package FourthLesson.Chapter_4_RefactorTank.Battlefield;

import FourthLesson.Chapter_4_RefactorTank.Battlefield.AbstractBattleFieldObject;

import java.awt.*;

public class Eagle extends AbstractBattleFieldObject {

    public Eagle() {

    }

    public Eagle(int x, int y) {
        super(x, y);
    }

    @Override
    public void destroy() {
        setX(-100);
        setY(-100);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(new Color(255, 255, 0));
        graphics.fillRect(getX(), getY(), 64, 64);
    }
}
