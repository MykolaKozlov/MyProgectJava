package SecondLesson.HomeWork.TigerArmor;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ActionField extends JPanel {

    private int step = 1;
    private int minimumFieldSize = 0;
    private int maximumFieldSize = 512;
    private int cellSize = 64;
    private boolean COLORDED_MODE = false;
    private BattleField battleField;
    private Tank tank;
    private Bullet bullet;
    private Tiger tiger;

    private String randomPosition() {
        String[] position = {"0_0", "64_128", "384_448"};
//        String[] position = {"0_0"};
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

    public void processTurn(Tank tank) throws Exception {
        repaint();
    }

    public void processMove(Tank tank) throws Exception {
        this.tank = tank;
        if (tank.getDirection() == Direction.LEFT && tank.getX() <= minimumFieldSize
                || tank.getDirection() == Direction.RIGHT
                && tank.getX() >= maximumFieldSize
                || tank.getDirection() == Direction.UP
                && tank.getY() <= minimumFieldSize
                || tank.getDirection() == Direction.DOWN
                && tank.getY() >= maximumFieldSize) {
            illegaleMove(tank.getDirection());
        } else {
            tank.turn(tank.getDirection());
            for (int i = 0; i < cellSize; i++) {
                moveLeft(tank.getDirection());
                moveRight(tank.getDirection());
                moveUp(tank.getDirection());
                moveDown(tank.getDirection());
                repaintMove();
            }
        }
    }

    private void illegaleMove(Direction direction) {
        System.out.println("[illegal move] " + "derection:" + direction + "||"
                + "tankX:" + tank.getX() + "||" + "tankY:" + tank.getY());
        return;
    }

    private void moveUp(Direction direction) {
        if (direction == Direction.UP) {
            tank.updateY(-step);
            System.out.println("[move up] " + "derection:" + direction + "||"
                    + "tankX:" + tank.getX() + "||" + "tankY:" + tank.getY());
        }
    }

    private void moveDown(Direction direction) {
        if (direction == Direction.DOWN) {
            tank.updateY(step);
            System.out.println("[move down] " + "derection:" + direction + "||"
                    + "tankX:" + tank.getX() + "||" + "tankY:" + tank.getY());
        }
    }

    private void moveLeft(Direction direction) {
        if (direction == Direction.LEFT) {
            tank.updateX(-step);
            System.out.println("[move left] " + "derection:" + direction + "||"
                    + "tankX:" + tank.getX() + "||" + "tankY:" + tank.getY());
        }
    }

    private void moveRight(Direction direction) {
        if (direction == Direction.RIGHT) {
            tank.updateX(step);
            System.out.println("[move right] " + "derection:" + direction
                    + "||" + "tankX:" + tank.getX() + "||" + "tankY:"
                    + tank.getY());
        }
    }

    private void repaintMove() throws InterruptedException {
        repaint();
        Thread.sleep(tank.getSpeed());
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

    public int fireDown() throws Exception {
        String str = getQuadrantXY(tank.getX(), tank.getY());
        int tankV = Integer.valueOf(str.substring(0, 1));
        int tankH = Integer.valueOf(str.substring(2, str.length()));
        tank.turn(Direction.DOWN);
        for (int idx = tankV; idx < battleField.getBattleField().length; idx++) {
            for (int j = tankH; j < tankH + 1; j++) {
                if (battleField.scanQuadrant(idx, j) == "B") {
                    tank.fire();
                }
            }
        }
        return tankV;
    }

    public int fireRight() throws Exception {
        String str = getQuadrantXY(tank.getX(), tank.getY());
        int tankV = Integer.valueOf(str.substring(0, 1));
        int tankH = Integer.valueOf(str.substring(2, str.length()));
        tank.turn(Direction.RIGHT);
        for (int idx = tankV; idx < tankV + 1; idx++) {
            for (int j = tankH; j < 9; j++) {
                if (battleField.scanQuadrant(idx, j) == "B") {
                    tank.fire();
                }
            }
        }
        return tankH;
    }

    public int fireUp() throws Exception {
        String str = getQuadrantXY(tank.getX(), tank.getY());
        int tankV = Integer.valueOf(str.substring(0, 1));
        int tankH = Integer.valueOf(str.substring(2, str.length()));
        tank.turn(Direction.UP);
        for (int idx = tankV; idx >= 0; idx--) {
            for (int j = tankH; j < tankH + 1; j++) {
                if (battleField.scanQuadrant(idx, j) == "B") {
                    tank.fire();
                }
            }
        }
        return tankV;
    }

    public int fireLeft() throws Exception {
        String str = getQuadrantXY(tank.getX(), tank.getY());
        int tankV = Integer.valueOf(str.substring(0, 1));
        int tankH = Integer.valueOf(str.substring(2, str.length()));
        tank.turn(Direction.LEFT);
        for (int idx = tankV; idx < tankV + 1; idx++) {
            for (int j = tankH; j >= 0; j--) {
                if (battleField.scanQuadrant(idx, j) == "B") {
                    tank.fire();
                }
            }
        }
        return tankH;
    }

    public void runTheGame() throws Exception {
//        tank.clean();
        tiger = new Tiger(0, 0, Direction.LEFT, this, battleField, 1);
        tank.fire();
        tank.fire();
        tank.fire();
        tank.fire();
        tank.fire();
        tank.fire();
    }

    private boolean processInterception() throws InterruptedException {
        String bulletCoordinate = getQuadrantXY(bullet.getX(), bullet.getY());
        String tigerCoordinate = getQuadrantXY(tiger.getX(), tiger.getY());
        int bulletXPosition = Integer.valueOf(bulletCoordinate.substring(0, bulletCoordinate.indexOf("_")));
        int bulletYPosition = Integer.valueOf(bulletCoordinate.substring(bulletCoordinate.lastIndexOf("_") + 1, bulletCoordinate.length()));
        int agressorXPosition = Integer.parseInt(tigerCoordinate.substring(0, tigerCoordinate.indexOf("_")));
        int agressorYPosition = Integer.parseInt(tigerCoordinate.substring(tigerCoordinate.lastIndexOf("_") + 1, tigerCoordinate.length()));
        if (bulletXPosition >= battleField.getBattleField().length
                - battleField.getBattleField().length
                && bulletXPosition < battleField.getBattleField().length
                && bulletYPosition >= battleField.getBattleField().length
                - battleField.getBattleField().length
                && bulletYPosition < battleField.getBattleField().length
                && battleField.scanQuadrant(bulletXPosition, bulletYPosition) == "B") {
            battleField.updateQuadrant(bulletXPosition, bulletYPosition, " ");
            return true;
        }
        if (bulletXPosition == agressorXPosition && bulletYPosition == agressorYPosition) {
            tiger.destroy();
//            Thread.sleep(3000);
//            tiger = new Tiger(Integer.parseInt(position.substring(0, position.indexOf("_"))), Integer.parseInt(position.substring(position.lastIndexOf("_") + 1, position.length())), Direction.LEFT, this, battleField, 1);
            return true;
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
        tank = new Tank(this, battleField);
//        tiger = new Tiger(Integer.parseInt(position.substring(0, position.indexOf("_"))), Integer.parseInt(position.substring(position.lastIndexOf("_") + 1, position.length())), Direction.LEFT, this, battleField);
        bullet = new Bullet(-100, -100, Direction.STOP);
        JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
        frame.setLocation(750, 150);
        frame.setMinimumSize(new Dimension(battleField.getBF_WIDTH() + 16,
                battleField.getBF_HEIGHT() + 39));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int i = 0;
        Color cc;
        for (int v = 0; v < 9; v++) {
            for (int h = 0; h < 9; h++) {
                if (COLORDED_MODE) {
                    if (i % 2 == 0) {
                        cc = new Color(252, 241, 177);
                    } else {
                        cc = new Color(233, 243, 255);
                    }
                } else {
                    cc = new Color(180, 180, 180);
                }
                i++;
                g.setColor(cc);
                g.fillRect(h * 64, v * 64, 64, 64);
            }
        }

        for (int j = 0; j < battleField.getDimentionY(); j++) {
            for (int k = 0; k < battleField.getDimentionX(); k++) {
                if (battleField.scanQuadrant(j, k).equals("B")) {
                    String coordinates = getQuadrant(j + 1, k + 1);
                    int separator = coordinates.indexOf("_");
                    int y = Integer.parseInt(coordinates
                            .substring(0, separator));
                    int x = Integer.parseInt(coordinates
                            .substring(separator + 1));
                    g.setColor(new Color(0, 0, 255));
                    g.fillRect(x, y, 64, 64);
                }
            }
        }

        g.setColor(new Color(255, 0, 0));
        g.fillRect(tank.getX(), tank.getY(), 64, 64);

        g.setColor(new Color(0, 255, 0));
        if (tank.getDirection() == Direction.UP) {
            g.fillRect(tank.getX() + 20, tank.getY(), 24, 34);
        } else if (tank.getDirection() == Direction.DOWN) {
            g.fillRect(tank.getX() + 20, tank.getY() + 30, 24, 34);
        } else if (tank.getDirection() == Direction.LEFT) {
            g.fillRect(tank.getX(), tank.getY() + 20, 34, 24);
        } else {
            g.fillRect(tank.getX() + 30, tank.getY() + 20, 34, 24);
        }

        g.setColor(new Color(255, 0, 255));
        g.fillRect(tiger.getX(), tiger.getY(), 64, 64);

        g.setColor(new Color(255, 255, 0));
        if (tiger.getDirection() == Direction.UP) {
            g.fillRect(tiger.getX() + 20, tiger.getY(), 24, 34);
        } else if (tiger.getDirection() == Direction.DOWN) {
            g.fillRect(tiger.getX() + 20, tiger.getY() + 30, 24, 34);
        } else if (tiger.getDirection() == Direction.LEFT) {
            g.fillRect(tiger.getX(), tiger.getY() + 20, 34, 24);
        } else {
            g.fillRect(tiger.getX() + 30, tiger.getY() + 20, 34, 24);
        }

        g.setColor(new Color(255, 255, 0));
        g.fillRect(bullet.getX(), bullet.getY(), 14, 14);
    }
}
