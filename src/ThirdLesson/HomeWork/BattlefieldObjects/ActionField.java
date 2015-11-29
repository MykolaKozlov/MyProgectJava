package ThirdLesson.HomeWork.BattlefieldObjects;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ActionField extends JPanel {

    private int step = 1;
    private int minimumFieldSize = 0;
    private int maximumFieldSize = 512;
    private int cellSize = 64;
    private BattleField battleField;
    private AbstractTank abstractTank;
    private Bullet bullet;
    private Tiger tiger;

    private String randomPosition() {
        String[] position = {"0_0", "64_128", "384_448"};
        Random random = new Random();
        return position[random.nextInt(position.length)];
    }

    private String position = randomPosition();

    public int getMinimumFieldSize() {
        return minimumFieldSize;
    }

    public int getMaximumFieldSize() {
        return maximumFieldSize;
    }

    public void processTurn(AbstractTank abstractTank) throws Exception {
        repaint();
    }

    public void processMove(AbstractTank abstractTank) throws Exception {
        this.abstractTank = abstractTank;
        if (abstractTank.getDirection() == Direction.LEFT && abstractTank.getX() <= minimumFieldSize
                || abstractTank.getDirection() == Direction.RIGHT
                && abstractTank.getX() >= maximumFieldSize
                || abstractTank.getDirection() == Direction.UP
                && abstractTank.getY() <= minimumFieldSize
                || abstractTank.getDirection() == Direction.DOWN
                && abstractTank.getY() >= maximumFieldSize) {
            illegaleMove(abstractTank.getDirection());
        } else {
            abstractTank.turn(abstractTank.getDirection());
            for (int i = 0; i < cellSize; i++) {
                moveLeft(abstractTank.getDirection());
                moveRight(abstractTank.getDirection());
                moveUp(abstractTank.getDirection());
                moveDown(abstractTank.getDirection());
                repaintMove();
            }
        }
    }

    private void illegaleMove(Direction direction) {
        System.out.println("[illegal move] " + "derection:" + direction + "||"
                + "tankX:" + abstractTank.getX() + "||" + "tankY:" + abstractTank.getY());
        return;
    }

    private void moveUp(Direction direction) {
        if (direction == Direction.UP) {
            abstractTank.updateY(-step);
            System.out.println("[move up] " + "derection:" + direction + "||"
                    + "tankX:" + abstractTank.getX() + "||" + "tankY:" + abstractTank.getY());
        }
    }

    private void moveDown(Direction direction) {
        if (direction == Direction.DOWN) {
            abstractTank.updateY(step);
            System.out.println("[move down] " + "derection:" + direction + "||"
                    + "tankX:" + abstractTank.getX() + "||" + "tankY:" + abstractTank.getY());
        }
    }

    private void moveLeft(Direction direction) {
        if (direction == Direction.LEFT) {
            abstractTank.updateX(-step);
            System.out.println("[move left] " + "derection:" + direction + "||"
                    + "tankX:" + abstractTank.getX() + "||" + "tankY:" + abstractTank.getY());
        }
    }

    private void moveRight(Direction direction) {
        if (direction == Direction.RIGHT) {
            abstractTank.updateX(step);
            System.out.println("[move right] " + "derection:" + direction
                    + "||" + "tankX:" + abstractTank.getX() + "||" + "tankY:"
                    + abstractTank.getY());
        }
    }

    private void repaintMove() throws InterruptedException {
        repaint();
        Thread.sleep(abstractTank.getSpeed());
    }

    public void processFire(Bullet bullet) throws Exception {
        this.bullet = bullet;

        while ((bullet.getX() > -15 && bullet.getX() < battleField
                .getBF_WIDTH())
                && (bullet.getY() > -15 && bullet.getY() < battleField
                .getBF_HEIGHT())) {
            if (bullet.getDirection() == Direction.UP) {
                bullet.updateY(-step);
            } else if (bullet.getDirection() == Direction.DOWN) {
                bullet.updateY(step);
            } else if (bullet.getDirection() == Direction.LEFT) {
                bullet.updateX(-step);
            } else {
                bullet.updateX(step);
            }
            if (processInterception() == true) {
                bullet.destroy();
            }
            repaintFire();
        }
    }

    private void repaintFire() throws InterruptedException {
        repaint();
        Thread.sleep(bullet.getSpeed());
    }

    public void runTheGame() throws Exception {
        abstractTank.fire();
        abstractTank.move();
        abstractTank.fire();
        abstractTank.fire();
        abstractTank.fire();
        abstractTank.fire();
        abstractTank.fire();
        abstractTank.fire();
    }

    private boolean processInterception() throws InterruptedException {
        String bulletCoordinate = getQuadrantXY(bullet.getX(), bullet.getY());
        String tigerCoordinate = getQuadrantXY(tiger.getX(), tiger.getY());
        int bulletXPosition = Integer.valueOf(bulletCoordinate.substring(0, bulletCoordinate.indexOf("_")));
        int bulletYPosition = Integer.valueOf(bulletCoordinate.substring(bulletCoordinate.lastIndexOf("_") + 1, bulletCoordinate.length()));
        int agressorXPosition = Integer.parseInt(tigerCoordinate.substring(0, tigerCoordinate.indexOf("_")));
        int agressorYPosition = Integer.parseInt(tigerCoordinate.substring(tigerCoordinate.lastIndexOf("_") + 1, tigerCoordinate.length()));

        if (bulletXPosition >= battleField.getAbstractBattleFieldObject().length
                - battleField.getAbstractBattleFieldObject().length
                && bulletXPosition < battleField.getAbstractBattleFieldObject().length
                && bulletYPosition >= battleField.getAbstractBattleFieldObject().length
                - battleField.getAbstractBattleFieldObject().length
                && bulletYPosition < battleField.getAbstractBattleFieldObject().length) {

            if (battleField.scanQuadrant(bulletXPosition, bulletYPosition) instanceof Brick && bulletYPosition == battleField.scanQuadrant(bulletXPosition, bulletYPosition).getX() / cellSize && bulletXPosition == battleField.scanQuadrant(bulletXPosition, bulletYPosition).getY() / cellSize) {
                battleField.scanQuadrant(bulletXPosition, bulletYPosition).destroy();
                return true;
            }
            if (bulletXPosition == agressorXPosition && bulletYPosition == agressorYPosition) {
                tiger.destroy();
                return true;
            }
        }
        return false;
    }

    public String getQuadrantXY(int x, int y) {
        return y / cellSize + "_" + x / cellSize;
    }

    public String getQuadrant(int v, int h) {
        return (v - 1) * cellSize + "_" + (h - 1) * cellSize;
    }

    public ActionField() throws Exception {
        battleField = new BattleField();
        abstractTank = new T34Defender(this, battleField);
        tiger = new Tiger(0, 0, Direction.LEFT, this, battleField, 1);
        bullet = new Bullet(-100, -100, Direction.STOP);
        JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
        frame.setLocation(750, 150);
        frame.setMinimumSize(new Dimension(battleField.getBF_WIDTH() + 16,
                battleField.getBF_HEIGHT() + 39));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        battleField.draw(graphics);
        bullet.draw(graphics);
        abstractTank.draw(graphics);
        tiger.draw(graphics);
    }
}
