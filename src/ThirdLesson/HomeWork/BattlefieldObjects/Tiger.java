package ThirdLesson.HomeWork.BattlefieldObjects;

import java.awt.*;

public class Tiger extends AbstractTank {
    protected int armor;

    public Tiger(int x, int y, Direction direction, ActionField actionField, BattleField battleField, int armor) {
        super(x, y, direction, actionField, battleField);
        this.armor = armor;
    }

    @Override
    public void destroy() {
        if (armor == 0) {
            super.destroy();
        }
        armor--;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(new Color(255, 0, 255));
        graphics.fillRect(this.getX(), this.getY(), 64, 64);

        graphics.setColor(new Color(255, 255, 0));
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
