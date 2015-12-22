package FourthLesson.Chapter_4_RefactorTank.Tank;

import FourthLesson.Chapter_4_RefactorTank.Action.Direction;
import FourthLesson.Chapter_4_RefactorTank.Battlefield.BattleField;

import java.awt.*;

public class T34Defender extends AbstractTank {

    public T34Defender(BattleField battleField) {
        super(battleField);
    }

    public T34Defender(int x, int y, Direction direction, BattleField battleField) {
        super(x, y, direction, battleField);
    }

    @Override
    public boolean isDestroyed() {
        return super.isDestroyed();
    }

    @Override
    public void turn(Direction direction) {
        super.turn(direction);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(new Color(0, 0, 0));
        graphics.fillRect(this.getX(), this.getY(), 64, 64);

        graphics.setColor(new Color(0, 255, 0));
        if (this.getDirection() == Direction.UP) {
            graphics.fillRect(this.getX() + 20, this.getY(), 24, 34);
        } else if (this.getDirection() == Direction.DOWN) {
            graphics.fillRect(this.getX() + 20, this.getY() + 30, 24, 34);
        } else if (this.getDirection() == Direction.LEFT) {
            graphics.fillRect(this.getX(), this.getY() + 20, 34, 24);
        } else {
            graphics.fillRect(this.getX() + 30, this.getY() + 20, 34, 24);
        }
    }
}
