package FourthLesson.Chapter_4_RefactorTank.Battlefield;

import java.awt.*;

public class Brick extends AbstractBattleFieldObject {


    public Brick(int x, int y) {
        super(x, y);
    }

    public Brick() {

    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(new Color(255, 0, 0));
        graphics.fillRect(getX(), getY(), 64, 64);
    }
}
