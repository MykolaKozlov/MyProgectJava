package ThirdLesson.HomeWork.BattlefieldObjects;

import java.awt.*;

public class Brick extends AbstractBattleFieldObject {


    public Brick(int x, int y) {
        super(x, y);
    }

    public Brick() {
        super();
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(new Color(255, 0, 0));
        graphics.fillRect(getX(), getY(), 64, 64);
    }

    @Override
    public void destroy() {
        setX(-100);
        setY(-100);
    }
}
