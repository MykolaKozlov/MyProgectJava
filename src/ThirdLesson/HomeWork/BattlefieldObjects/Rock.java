package ThirdLesson.HomeWork.BattlefieldObjects;

import java.awt.*;

public class Rock extends AbstractBattleFieldObject {

    public Rock() {

    }

    public Rock(int x, int y) {
        super(x, y);
    }

    @Override
    public void destroy() {
        setX(-100);
        setY(-100);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(new Color(101, 67, 33));
        graphics.fillRect(getX(), getY(), 64, 64);
    }
}
