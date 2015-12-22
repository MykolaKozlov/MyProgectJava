package FourthLesson.Chapter_4_RefactorTank.Battlefield;

import java.awt.*;

public class Eagle extends AbstractBattleFieldObject {

    public Eagle() {

    }

    public Eagle(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(new Color(255, 255, 0));
        graphics.fillRect(getX(), getY(), 64, 64);
    }
}
