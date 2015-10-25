package FirstLesson.TankOOP;

import javax.swing.*;
import java.awt.*;

public class ActionField extends JPanel {

    private int step = 1;
    private int minimumFieldSize = 0;
    private int maximumFieldSize = 512;
    private int moveUp = 1;
    private int moveDown = 2;
    private int moveLeft = 3;
    private int moveRight = 4;
    private int cellSize = 64;
    private boolean COLORDED_MODE = false;
    private BattleFirld battleFirld;
    private Tank tank;
    private Bullet bullet;

    public int getMinimumFieldSize() {
        return minimumFieldSize;
    }

    public int getMaximumFieldSize() {
        return maximumFieldSize;
    }

    public int getMoveUp() {
        return moveUp;
    }

    public int getMoveDown() {
        return moveDown;
    }

    public int getMoveLeft() {
        return moveLeft;
    }

    public int getMoveRight() {
        return moveRight;
    }

    public void processTurn(Tank tank) throws Exception {
        repaint();
    }

    public void processMove(Tank tank) throws Exception {
        this.tank = tank;
        if (tank.getDirection() == moveLeft && tank.getX() <= minimumFieldSize
                || tank.getDirection() == moveRight
                && tank.getX() >= maximumFieldSize
                || tank.getDirection() == moveUp
                && tank.getY() <= minimumFieldSize
                || tank.getDirection() == moveDown
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

    private void illegaleMove(int direction) {
        System.out.println("[illegal move] " + "derection:" + direction + "||"
                + "tankX:" + tank.getX() + "||" + "tankY:" + tank.getY());
        return;
    }

    private void moveUp(int direction) {
        if (direction == moveUp) {
            tank.updateY(-step);
            System.out.println("[move up] " + "derection:" + direction + "||"
                    + "tankX:" + tank.getX() + "||" + "tankY:" + tank.getY());
        }
    }

    private void moveDown(int direction) {
        if (direction == moveDown) {
            tank.updateY(step);
            System.out.println("[move down] " + "derection:" + direction + "||"
                    + "tankX:" + tank.getX() + "||" + "tankY:" + tank.getY());
        }
    }

    private void moveLeft(int direction) {
        if (direction == moveLeft) {
            tank.updateX(-step);
            System.out.println("[move left] " + "derection:" + direction + "||"
                    + "tankX:" + tank.getX() + "||" + "tankY:" + tank.getY());
        }
    }

    private void moveRight(int direction) {
        if (direction == moveRight) {
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

        while ((bullet.getX() > -15 && bullet.getX() < battleFirld
                .getBF_WIDTH())
                && (bullet.getY() > -15 && bullet.getY() < battleFirld
                .getBF_HEIGHT())) {
            if (bullet.getDirection() == moveUp) {
                bullet.updateY(-step);
            } else if (bullet.getDirection() == moveDown) {
                bullet.updateY(step);
            } else if (bullet.getDirection() == moveLeft) {
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
        tank.turn(moveDown);
        for (int idx = tankV; idx < battleFirld.getBattleField().length; idx++) {
            for (int j = tankH; j < tankH + 1; j++) {
                if (battleFirld.scanQuadrant(idx, j) == "B") {
                    tank.fire();
                }
            }
        }return tankV;
    }

    public int fireRight() throws Exception {
        String str = getQuadrantXY(tank.getX(), tank.getY());
        int tankV = Integer.valueOf(str.substring(0, 1));
        int tankH = Integer.valueOf(str.substring(2, str.length()));
        tank.turn(moveRight);
        for (int idx = tankV; idx < tankV + 1; idx++) {
            for (int j = tankH; j < 9; j++) {
                if (battleFirld.scanQuadrant(idx, j) == "B") {
                    tank.fire();
                }
            }
        }return tankH;
    }

    public int fireUp() throws Exception {
        String str = getQuadrantXY(tank.getX(), tank.getY());
        int tankV = Integer.valueOf(str.substring(0, 1));
        int tankH = Integer.valueOf(str.substring(2, str.length()));
        tank.turn(moveUp);
        for (int idx =  tankV; idx >= 0; idx--) {
            for (int j =  tankH; j <  tankH + 1; j++) {
                if (battleFirld.scanQuadrant(idx, j) == "B") {
                    tank.fire();
                }
            }
        }return tankV;
    }

    public int fireLeft() throws Exception {
        String str = getQuadrantXY(tank.getX(), tank.getY());
        int tankV = Integer.valueOf(str.substring(0, 1));
        int tankH = Integer.valueOf(str.substring(2, str.length()));
        tank.turn(moveLeft);
        for (int idx = tankV; idx < tankV + 1; idx++) {
            for (int j = tankH; j >= 0; j--) {
                if (battleFirld.scanQuadrant(idx, j) == "B") {
                    tank.fire();
                }
            }
        }return tankH;
    }

    public void runTheGame() throws Exception {
        tank.clean();

//		 tank.moveToQuadrant(1, 5);
//		 tank.moveToQuadrant(2, 5);
//		 tank.moveToQuadrant(5, 5);
//		 tank.moveToQuadrant(1, 5);
//		 tank.moveToQuadrant(5, 2);

        // tank.fire();
        // tank.move();
        // tank.turn(3);
        // tank.move();
        // tank.move();
        // tank.fire();
        // tank.turn(2);
        // tank.fire();
        // tank.move();
        // tank.turn(1);
        // tank.fire();
        // tank.move();
        // tank.turn(4);
        // tank.fire();
        // tank.move();
    }

    private boolean processInterception() {
        String str = getQuadrantXY(bullet.getX(), bullet.getY());
        int i = Integer.valueOf(str.substring(0, 1));
        int q = Integer.valueOf(str.substring(2, str.length()));
        if (i >= battleFirld.getBattleField().length
                - battleFirld.getBattleField().length
                && i < battleFirld.getBattleField().length
                && q >= battleFirld.getBattleField().length
                - battleFirld.getBattleField().length
                && q < battleFirld.getBattleField().length
                && battleFirld.scanQuadrant(i, q) == "B") {
            battleFirld.updateQuadrant(i, q, " ");
            return true;
        } else
            return false;
    }

    public String getQuadrantXY(int x, int y) {
        return y / cellSize + "_" + x / cellSize;
    }

    public String getQuadrant(int v, int h) {
        return (v - 1) * cellSize + "_" + (h - 1) * cellSize;
    }

    public ActionField() throws Exception {
        battleFirld = new BattleFirld();
        tank = new Tank(this, battleFirld);
        bullet = new Bullet(-100, -100, -1);

        JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
        frame.setLocation(750, 150);
        frame.setMinimumSize(new Dimension(battleFirld.getBF_WIDTH() + 16,
                battleFirld.getBF_HEIGHT() + 39));
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

        for (int j = 0; j < battleFirld.getDimentionY(); j++) {
            for (int k = 0; k < battleFirld.getDimentionX(); k++) {
                if (battleFirld.scanQuadrant(j, k).equals("B")) {
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
        if (tank.getDirection() == 1) {
            g.fillRect(tank.getX() + 20, tank.getY(), 24, 34);
        } else if (tank.getDirection() == 2) {
            g.fillRect(tank.getX() + 20, tank.getY() + 30, 24, 34);
        } else if (tank.getDirection() == 3) {
            g.fillRect(tank.getX(), tank.getY() + 20, 34, 24);
        } else {
            g.fillRect(tank.getX() + 30, tank.getY() + 20, 34, 24);
        }

        g.setColor(new Color(255, 255, 0));
        g.fillRect(bullet.getX(), bullet.getY(), 14, 14);
    }
}
