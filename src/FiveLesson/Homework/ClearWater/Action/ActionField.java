package FiveLesson.Homework.ClearWater.Action;

import FiveLesson.Homework.ClearWater.Battlefield.*;
import FiveLesson.Homework.ClearWater.Tank.Action;
import FiveLesson.Homework.ClearWater.Tank.*;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class ActionField extends JPanel {

    private int step = 1;
    private int minimumFieldSize = 0;
    private int maximumFieldSize = 512;
    private int cellSize = 64;
    private BattleField battleField;
    private Tank defender;
    private Tank agressor;
    private Bullet bullet;
    private LinkedList<Action> actions = new LinkedList();
    private int targetX = 0;
    private int targetY = 0;

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

    public void processTurn(Tank tank) throws Exception {
        repaint();
    }

    public void processMove(Tank tank) throws Exception {
        String tankQuadrant = getQuadrantXY(tank.getX(), tank.getY());
        int v = Integer.parseInt(tankQuadrant.split("_")[0]);
        int h = Integer.parseInt(tankQuadrant.split("_")[1]);
        if (tank.getDirection() == Direction.LEFT && tank.getX() <= minimumFieldSize
                || tank.getDirection() == Direction.RIGHT
                && tank.getX() >= maximumFieldSize
                || tank.getDirection() == Direction.UP
                && tank.getY() <= minimumFieldSize
                || tank.getDirection() == Direction.DOWN
                && tank.getY() >= maximumFieldSize) {
            illegaleMove(tank, tank.getDirection());
        } else {
            tank.turn(tank.getDirection());
            if (tank.getDirection() == Direction.UP) {
                v--;
            } else if (tank.getDirection() == Direction.DOWN) {
                v++;
            } else if (tank.getDirection() == Direction.RIGHT) {
                h++;
            } else if (tank.getDirection() == Direction.LEFT) {
                h--;
            }
            AbstractBattleFieldObject bfObject = battleField.scanQuadrant(v, h);
            if ((agressor.getDirection() == Direction.UP || defender.getDirection() == Direction.DOWN) && (defender.getY() + cellSize == agressor.getY()) && (defender.getX() == agressor.getX())) {
                illegaleMove(tank, tank.getDirection());
            } else if ((agressor.getDirection() == Direction.DOWN || defender.getDirection() == Direction.UP) && (defender.getY() - cellSize == agressor.getY()) && (defender.getX() == agressor.getX())) {
                illegaleMove(tank, tank.getDirection());
            } else if ((agressor.getDirection() == Direction.LEFT || defender.getDirection() == Direction.RIGHT) && (defender.getY() == agressor.getY()) && (defender.getX() + cellSize == agressor.getX())) {
                illegaleMove(tank, tank.getDirection());
            } else if ((agressor.getDirection() == Direction.RIGHT || defender.getDirection() == Direction.LEFT) && (defender.getY() == agressor.getY()) && (defender.getX() - cellSize == agressor.getX())) {
                illegaleMove(tank, tank.getDirection());
            } else if (!(bfObject instanceof CapBrick) && !bfObject.isDestroyed()) {
                illegaleMove(tank, tank.getDirection());
            } else {
                for (int i = 0; i < cellSize; i++) {
                    if (v > 0 || v < 8 || h > 0 || h < 8) {
                        moveLeft(tank, tank.getDirection());
                        moveRight(tank, tank.getDirection());
                        moveUp(tank, tank.getDirection());
                        moveDown(tank, tank.getDirection());
                        repaintMove(tank);
                    }
                }
            }
        }
    }

    private void illegaleMove(Tank tank, Direction direction) {
//        System.out.println("[illegal move] " + "derection:" + direction + "||"
//                + "tankX:" + tank.getX() + "||" + "tankY:" + tank.getY());
        return;
    }

    private void moveUp(Tank tank, Direction direction) {
        if (direction == Direction.UP) {
            tank.updateY(-step);
//            System.out.println("[move up] " + "derection:" + direction + "||"
//                    + "tankX:" + tank.getX() + "||" + "tankY:" + tank.getY());
        }
    }

    private void moveDown(Tank tank, Direction direction) {
        if (direction == Direction.DOWN) {
            tank.updateY(step);
//            System.out.println("[move down] " + "derection:" + direction + "||"
//                    + "tankX:" + tank.getX() + "||" + "tankY:" + tank.getY());
        }
    }

    private void moveLeft(Tank tank, Direction direction) {
        if (direction == Direction.LEFT) {
            tank.updateX(-step);
//            System.out.println("[move left] " + "derection:" + direction + "||"
//                    + "tankX:" + tank.getX() + "||" + "tankY:" + tank.getY());
        }
    }

    private void moveRight(Tank tank, Direction direction) {
        if (direction == Direction.RIGHT) {
            tank.updateX(step);
//            System.out.println("[move right] " + "derection:" + direction
//                    + "||" + "tankX:" + tank.getX() + "||" + "tankY:"
//                    + tank.getY());
        }
    }

    private void repaintMove(Tank tank) throws InterruptedException {
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
            if (processInterception()) {
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
        while (!battleField.scanQuadrant(targetY, targetX).isDestroyed()) {
            destroyTheTarget(agressor);
            for (int i = 0; i < actions.size(); i++) {
                if (actions.get(i) != null) {
                    processAction(actions.get(i), agressor);
                }
            }
        }

//        destroyTheTarget(agressor);
//        for (int i = 0; i < actions.size(); i++) {
//            if (actions.get(i) != null) {
//                processAction(actions.get(i), agressor);
//            }
//        }
//        destroyTheTarget(agressor);
//        for (int i = 0; i < actions.length; i++){
//            if (actions[i] != null){
//                processAction(actions[i], agressor);
//            }
//        }


//        processAction(defender.moveToQuadrant(1, 5), defender);
    }

    private void processAction(Action action, Tank tank) throws Exception {
        if (action == Action.FIRE) {
            processFire(tank.fire());
        } else if (action == Action.MOVE) {
            processMove(tank);
        } else if (action == Action.TURN) {
            processTurn(tank);
        } else if (action == Action.DOWN) {
            tank.turn(Direction.DOWN);
            processTurn(tank);
        } else if (action == Action.UP) {
            tank.turn(Direction.UP);
            processTurn(tank);
        } else if (action == Action.LEFT) {
            tank.turn(Direction.LEFT);
            processTurn(tank);
        } else if (action == Action.RIGHT) {
            tank.turn(Direction.RIGHT);
            processTurn(tank);
        }
    }

    private boolean processInterception() {
        String coordinates = getQuadrantXY(bullet.getX(), bullet.getY());
        int y = Integer.parseInt(coordinates.split("_")[0]);
        int x = Integer.parseInt(coordinates.split("_")[1]);

        if (y >= 0 && y < 9 && x >= 0 && x < 9) {
            AbstractBattleFieldObject bfObject = battleField.scanQuadrant(y, x);
            if (!bfObject.isDestroyed() && !(bfObject instanceof CapBrick) && !(bfObject instanceof Water)) {
                battleField.destroyObject(y, x);
                return true;
            }

            // check aggressor
            if (!agressor.isDestroyed() && checkInterception(getQuadrantXY(agressor.getX(), agressor.getY()), coordinates)) {
                agressor.destroy();
                return true;
            }

            // check aggressor
            if (!defender.isDestroyed() && checkInterception(getQuadrantXY(defender.getX(), defender.getY()), coordinates)) {
                defender.destroy();
                return true;
            }
        }
        return false;
    }

    private boolean checkInterception(String object, String quadrant) {
        int oy = Integer.parseInt(object.split("_")[0]);
        int ox = Integer.parseInt(object.split("_")[1]);

        int qy = Integer.parseInt(quadrant.split("_")[0]);
        int qx = Integer.parseInt(quadrant.split("_")[1]);

        if (oy >= 0 && oy < 9 && ox >= 0 && ox < 9) {
            if (oy == qy && ox == qx) {
                return true;
            }
        }
        return false;
    }

    public void destroyTheTarget(Tank tank) {
//        find the target
        for (int i = 0; i < battleField.getAbstractBattleFieldObject().length; i++) {
            for (int j = 0; j < battleField.getAbstractBattleFieldObject()[i].length; j++) {
                AbstractBattleFieldObject bfObject = battleField.scanQuadrant(i, j);
                if (bfObject instanceof Eagle) {
                    targetY = i;
                    targetX = j;
                    break;
                }
            }
        }

//        scan way the target
        if (tank.getX() / 64 < targetX && tank.getY() / 64 < targetY) {
            checkRightAndDown(tank, targetX);
        }

        if (tank.getX() / 64 == targetX) {
            checkDown(tank, targetY);
        }

        if (tank.getY() / 64 >= targetY) {
            checkRightAndUp(tank);
        }
    }

    private void checkRightAndUp(Tank tank) {
        actions.removeAll(actions);
        actions.addLast(Action.RIGHT);
        for (int i = tank.getY() / 64; i <= tank.getY() / 64; i++) {
            for (int j = tank.getX() / 64 + 1; j <= targetX; j++) {
                AbstractBattleFieldObject bfObject = battleField.scanQuadrant(i, j);
                if (bfObject instanceof Rock || bfObject instanceof Brick || bfObject instanceof Eagle) {
                    actions.addLast(Action.FIRE);
                }
                if (bfObject instanceof Water) {
                    actions.removeAll(actions);
                    actions.addLast(Action.UP);
                    for (int f = tank.getX() / 64; f <= tank.getX() / 64; f++) {
                        for (int g = tank.getY() / 64 - 1; g >= tank.getY() / 64 - 1; g--) {
                            AbstractBattleFieldObject ggg = battleField.scanQuadrant(g, f);
                            if (ggg instanceof Rock || ggg instanceof Brick || ggg instanceof Eagle) {
                                actions.addLast(Action.FIRE);
                            }
                        }
                    }
                    actions.addLast(Action.MOVE);
                    return;
                }
            }
            for (int k = 0; k < targetX; k++) {
                actions.addLast(Action.MOVE);
            }
        }
        actions.addLast(Action.UP);
        for (int y = targetY; y <= targetY; y++) {
            for (int g = 1; g < 9; g++) {
                AbstractBattleFieldObject bfObject = battleField.scanQuadrant(g, y);
                if (bfObject instanceof Rock || bfObject instanceof Brick || bfObject instanceof Eagle) {
                    actions.addLast(Action.FIRE);
                }
            }
        }
    }

    private void checkDown(Tank tank, int targetY) {
        actions.addLast(Action.DOWN);
        for (int i = tank.getX() / 64; i <= tank.getX() / 64; i++) {
            for (int j = tank.getY() / 64 + 1; j <= targetY; j++) {
                AbstractBattleFieldObject bfObject = battleField.scanQuadrant(j, i);
                if (bfObject instanceof Rock || bfObject instanceof Brick || bfObject instanceof Eagle) {
                    actions.addLast(Action.FIRE);
                }
            }
            for (int k = 0; k < targetY; k++) {
                actions.addLast(Action.MOVE);
            }
        }
    }

    private void checkRightAndDown(Tank tank, int targetX) {
        actions.removeAll(actions);
        actions.addLast(Action.RIGHT);
        for (int i = tank.getY() / 64; i <= tank.getY() / 64; i++) {
            for (int j = tank.getX() / 64 + 1; j <= targetX; j++) {
                AbstractBattleFieldObject bfObject = battleField.scanQuadrant(i, j);
                if (bfObject instanceof Rock || bfObject instanceof Brick || bfObject instanceof Eagle) {
                    actions.addLast(FiveLesson.Homework.ClearWater.Tank.Action.FIRE);
                }
                if (bfObject instanceof Water) {
                    actions.removeAll(actions);
                    actions.addLast(Action.DOWN);
                    for (int f = tank.getX() / 64; f <= tank.getX() / 64; f++) {
                        for (int g = tank.getY() / 64 + 1; g <= tank.getY() / 64 + 1; g++) {
                            AbstractBattleFieldObject ggg = battleField.scanQuadrant(g, f);
                            if (ggg instanceof Rock || ggg instanceof Brick || ggg instanceof Eagle) {
                                actions.addLast(Action.FIRE);
                            }
                        }
                    }
                    actions.addLast(Action.MOVE);
                    return;
                }
            }
            for (int k = 0; k < targetX; k++) {
                actions.addLast(Action.MOVE);
            }
        }
        actions.addLast(Action.DOWN);
        for (int y = targetX; y <= targetX; y++) {
            for (int g = 1; g < 9; g++) {
                AbstractBattleFieldObject bfObject = battleField.scanQuadrant(g, y);
                if (bfObject instanceof Rock || bfObject instanceof Brick || bfObject instanceof Eagle) {
                    actions.addLast(Action.FIRE);
                }
            }
        }
    }

    public String getQuadrantXY(int x, int y) {
        return y / cellSize + "_" + x / cellSize;
    }

    public String getQuadrant(int v, int h) {
        return (v - 1) * cellSize + "_" + (h - 1) * cellSize;
    }

    public ActionField() throws Exception {
        battleField = new BattleField();
        defender = new T34Defender(512, 256, Direction.DOWN, battleField);
        agressor = new Tiger(0, 0, Direction.DOWN, battleField, 1);
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
        defender.draw(graphics);
        agressor.draw(graphics);
    }
}
