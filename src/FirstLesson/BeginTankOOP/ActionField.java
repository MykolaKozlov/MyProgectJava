package FirstLesson.BeginTankOOP;

import javax.swing.*;

public class ActionField extends JPanel {

    void runTheGame() throws Exception {
        clean();
    }

    void clean() throws Exception {
        Tank tank = new Tank();
        BattleField battle = new BattleField();

        tank.tankH = tank.tankX / Tank.cellSize;
        tank.tankV = tank.tankY / Tank.cellSize;
        if (battle.battleField[tank.tankH][tank.tankV] == "B") {
            System.out.println("Initial data are false!");
            System.out.println("GAME OVER!!!");
            return;
        } else {
            for (int i = tank.tankV + 1; i >= 1; i--) {
                fireUp();
                fireRight();
                fireDown();
                fireLeft();
                moveToQuadrant(i, tank.tankH + 1);
            }
            for (int i = tank.tankH + 1; i >= 1; i--) {
                fireUp();
                fireRight();
                fireDown();
                fireLeft();
                moveToQuadrant(tank.tankV + 1, i);
            }
            for (int i = 0; i <= battle.battleField.length + 1; i++) {
                fireUp();
                fireRight();
                fireDown();
                fireLeft();
                moveToQuadrant(i, tank.beginY);
            }
        }
        // fire
        fireUp();
        fireRight();
        fireDown();
        fireLeft();
        System.out.println("GAME OVER!!!");
    }


    public void fireDown() throws Exception {
        Tank tank = new Tank();
        BattleField battle = new BattleField();


        tank.tankH = tank.tankX / Tank.cellSize;
        tank.tankV = tank.tankY / Tank.cellSize;
        tank.turn(tank.moveDown);
        for (int idx = tank.tankV; idx < battle.battleField.length; idx++) {
            for (int j = tank.tankH; j < tank.tankH + 1; j++) {
                if (battle.battleField[idx][j] == "B") {
                    tank.fire();
                }
            }
        }
    }

    public void fireRight() throws Exception {
        Tank tank = new Tank();
        BattleField battle = new BattleField();


        tank.tankH = tank.tankX / Tank.cellSize;
        tank.tankV = tank.tankY / Tank.cellSize;
        tank.turn(tank.moveRight);
        for (int idx = tank.tankV; idx < tank.tankV + 1; idx++) {
            for (int j = tank.tankH; j < battle.battleField[idx].length; j++) {
                if (battle.battleField[idx][j] == "B") {
                    tank.fire();
                }
            }
        }
    }

    public void fireUp() throws Exception {
        Tank tank = new Tank();
        BattleField battle = new BattleField();

        tank.tankH = tank.tankX / Tank.cellSize;
        tank.tankV = tank.tankY / Tank.cellSize;
        tank.turn(tank.moveUp);
        for (int idx = tank.tankV; idx >= 0; idx--) {
            for (int j = tank.tankH; j < tank.tankH + 1; j++) {
                if (battle.battleField[idx][j] == "B") {
                    tank.fire();
                }
            }
        }
    }

    public void fireLeft() throws Exception {
        Tank tank = new Tank();
        BattleField battle = new BattleField();


        tank.tankH = tank.tankX / Tank.cellSize;
        tank.tankV = tank.tankY / Tank.cellSize;
        tank.turn(tank.moveLeft);
        for (int idx = tank.tankV; idx < tank.tankV + 1; idx++) {
            for (int j = tank.tankH; j >= 0; j--) {
                if (battle.battleField[idx][j] == "B") {
                    tank.fire();
                }
            }
        }
    }


    public boolean processInterception() throws Exception {
        Tank tank = new Tank();
        BattleField battle = new BattleField();
        Bullet bullet = new Bullet();

        String str = getQuadrantXY(bullet.bulletX, bullet.bulletY);
        int i = Integer.valueOf(str.substring(0, 1));
        int q = Integer.valueOf(str.substring(2, str.length()));
        if (i >= tank.minimumCoordinate && i < tank.maximumCoordinate
                && q >= tank.minimumCoordinate && q < tank.maximumCoordinate
                && battle.battleField[i][q] == "B") {
            battle.battleField[i][q] = " ";
            return true;
        } else
            return false;
    }

    public static String getQuadrantXY(int x, int y) {
        new Tank();
        return y / Tank.cellSize + "_" + x / Tank.cellSize;
    }

    public static String getQuadrant(int v, int h) {
        new Tank();
        return (v - 1) * Tank.cellSize + "_" + (h - 1) * Tank.cellSize;
    }


    public void illegaleMove(int direction) {
        Tank tank = new Tank();
        if (direction == tank.moveLeft && tank.tankX <= tank.minimumFieldSize || direction == tank.moveRight
                && tank.tankX >= tank.maximumFieldSize || direction == tank.moveUp && tank.tankY <= tank.minimumFieldSize
                || direction == tank.moveDown && tank.tankY >= tank.maximumFieldSize) {
            System.out.println("[illegal move] " + "derection:" + direction
                    + "||" + "tankX:" + tank.tankX + "||" + "tankY:" + tank.tankY);
            return;
        }
    }

    public void moveUp(int direction) {
        Tank tank = new Tank();
        if (direction == tank.moveUp) {
            tank.tankY -= tank.step;
            System.out.println("[move up] " + "derection:" + direction + "||"
                    + "tankX:" + tank.tankX + "||" + "tankY:" + tank.tankY);
        }
    }

    public void moveDown(int direction) {
        Tank tank = new Tank();
        if (direction == tank.moveDown) {
            tank.tankY += tank.step;
            System.out.println("[move down] " + "derection:" + direction + "||"
                    + "tankX:" + tank.tankX + "||" + "tankY:" + tank.tankY);
        }
    }

    public void moveLeft(int direction) {
        Tank tank = new Tank();
        if (direction == tank.moveLeft) {
            tank.tankX -= tank.step;
            System.out.println("[move left] " + "derection:" + direction + "||"
                    + "tankX:" + tank.tankX + "||" + "tankY:" + tank.tankY);
        }
    }

    public void moveRight(int direction) {
        Tank tank = new Tank();
        if (direction == tank.moveRight) {
            tank.tankX += tank.step;
            System.out.println("[move right] " + "derection:" + direction
                    + "||" + "tankX:" + tank.tankX + "||" + "tankY:" + tank.tankY);
        }
    }

    public void repaintMove() throws Exception {
        Tank tank = new Tank();
        repaint();
        Thread.sleep(tank.speed);
    }

    void moveToQuadrant(int v, int h) throws Exception {
        String coordinates = getQuadrant(v, h);
        int separator = coordinates.indexOf("_");
        int x = Integer.parseInt(coordinates.substring(0, separator));
        int y = Integer.parseInt(coordinates.substring(separator + 1));
        moveDownAndFire(x);
        moveUpAndFire(x);
        moveRightAndFire(y);
        moveLeftAndFire(y);
    }

    public void moveDownAndFire(int x) throws Exception {
        Tank tank = new Tank();
        if (tank.tankY < x && x >= tank.minimumFieldSize && x <= tank.maximumFieldSize) {
            while (tank.tankY != x) {
                tank.move(tank.moveDown);
            }
        }
    }

    public void moveUpAndFire(int x) throws Exception {
        Tank tank = new Tank();
        if (tank.tankY > x && x >= tank.minimumFieldSize && x <= tank.maximumFieldSize) {
            while (tank.tankY != x) {
                tank.move(tank.moveUp);
            }
        }
    }

    public void moveRightAndFire(int y) throws Exception {
        Tank tank = new Tank();
        if (tank.tankX < y && y >= tank.minimumFieldSize && y <= tank.maximumFieldSize) {
            while (tank.tankX != y) {
                tank.move(tank.moveRight);
            }
        }
    }

    public void moveLeftAndFire(int y) throws Exception {
        Tank tank = new Tank();
        if (tank.tankX > y && y >= tank.minimumFieldSize && y <= tank.maximumFieldSize) {
            while (tank.tankX != y) {
                tank.move(tank.moveLeft);
            }
        }
    }

}
