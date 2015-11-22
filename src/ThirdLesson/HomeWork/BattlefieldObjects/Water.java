package ThirdLesson.HomeWork.BattlefieldObjects;

import java.awt.*;

public class Water extends AbstractBattleFieldObject {

    public Water() {
        super();
    }

    public Water(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(new Color(0, 100, 255));
        graphics.fillRect(getX(), getY(), 64, 64);
    }
}
