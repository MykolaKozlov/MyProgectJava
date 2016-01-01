package FourthLesson.HomeWork.AttackTank.Battlefield;

import java.awt.*;

public class Rock extends AbstractBattleFieldObject {

    public Rock() {

    }

    public Rock(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(new Color(101, 67, 33));
        graphics.fillRect(getX(), getY(), 64, 64);
    }
}
