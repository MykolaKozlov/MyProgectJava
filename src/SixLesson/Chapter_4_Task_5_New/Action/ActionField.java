package SixLesson.Chapter_4_Task_5_New.Action;

import SixLesson.Chapter_4_Task_5_New.Battlefield.*;
import SixLesson.Chapter_4_Task_5_New.Tank.Action;
import SixLesson.Chapter_4_Task_5_New.Tank.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    private int targetX = 0;
    private int targetY = 0;

    public boolean isRunAgressor = false;
    public boolean isRunDefender = false;

    private String randomPosition() {
        String[] position = {"0_0", "64_128", "384_448"};
        Random random = new Random();
        return position[random.nextInt(position.length)];
    }

    public void processTurn(Tank tank) throws Exception {
        repaint();
    }

    public void processMove(Tank tank) throws Exception {
        String tankQuadrant = getQuadrantXY(tank.getX(), tank.getY());
        int v = Integer.parseInt(tankQuadrant.split("_")[0]);
        int h = Integer.parseInt(tankQuadrant.split("_")[1]);
//        check move
        if (tank.getDirection() == Direction.LEFT && tank.getX() <= minimumFieldSize
                || tank.getDirection() == Direction.RIGHT
                && tank.getX() >= maximumFieldSize
                || tank.getDirection() == Direction.UP
                && tank.getY() <= minimumFieldSize
                || tank.getDirection() == Direction.DOWN
                && tank.getY() >= maximumFieldSize) {
            return;
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
//          check tanks cross
            AbstractBattleFieldObject bfObject = battleField.scanQuadrant(v, h);
            if ((agressor.getDirection() == Direction.UP || defender.getDirection() == Direction.DOWN) && (defender.getY() + cellSize == agressor.getY()) && (defender.getX() == agressor.getX())) {
                return;
            } else if ((agressor.getDirection() == Direction.DOWN || defender.getDirection() == Direction.UP) && (defender.getY() - cellSize == agressor.getY()) && (defender.getX() == agressor.getX())) {
                return;
            } else if ((agressor.getDirection() == Direction.LEFT || defender.getDirection() == Direction.RIGHT) && (defender.getY() == agressor.getY()) && (defender.getX() + cellSize == agressor.getX())) {
                return;
            } else if ((agressor.getDirection() == Direction.RIGHT || defender.getDirection() == Direction.LEFT) && (defender.getY() == agressor.getY()) && (defender.getX() - cellSize == agressor.getX())) {
                return;
            } else if (!(bfObject instanceof CapBrick) && !bfObject.isDestroyed()) {
                return;
            } else {
                for (int i = 0; i < cellSize; i++) {
                    if (v > 0 || v < 8 || h > 0 || h < 8) {
                        tank.updateX(step);
                        tank.updateY(step);
                        repaintMove(tank);
                    }
                }
            }
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
            bullet.updateX(step);
            bullet.updateY(step);
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
//        if findTheTarget(null) - search Eagle;
//        if findTheTarget(tank) - search Tank;
        while (true) {
            System.out.println("");
            if (isRunAgressor) {
                findTheTarget(defender);
                destroyTheTarget(agressor, defender);
                break;
            }
            if (isRunDefender) {
                findTheTarget(agressor);
                destroyTheTarget(defender, agressor);
                break;
            }
        }

    }

    public void destroyTheTarget(Tank tank, Tank target) throws Exception {
        while (!battleField.scanQuadrant(targetY, targetX).isDestroyed()) {
            if (tank.getX() / 64 <= targetX && tank.getY() / 64 <= targetY) {
                scanRightAndDown(tank);
            } else if (tank.getX() / 64 >= targetX && tank.getY() / 64 <= targetY) {
                scanLeftAndDown(tank);
            } else if (tank.getX() / 64 >= targetX && tank.getY() / 64 >= targetY) {
                scanLeftAndUp(tank);
            } else {
                scanRightAndUp(tank);
            }
            if (target != null) {
                if (target.isDestroyed()) {
                    break;
                }
            }
        }
    }

    private void actionFire(Tank tank) throws Exception {
        processFire(tank.fire());
    }

    private void actionMoveUp(Tank tank) throws Exception {
        tank.turn(Direction.UP);
        processTurn(tank);
        processMove(tank);
    }

    private void actionMoveDown(Tank tank) throws Exception {
        tank.turn(Direction.DOWN);
        processTurn(tank);
        processMove(tank);
    }

    private void actionMoveRight(Tank tank) throws Exception {
        tank.turn(Direction.RIGHT);
        processTurn(tank);
        processMove(tank);
    }

    private void actionTurnUp(Tank tank) throws Exception {
        tank.turn(Direction.UP);
        processTurn(tank);
    }

    private void actionTurnDown(Tank tank) throws Exception {
        tank.turn(Direction.DOWN);
        processTurn(tank);
    }

    private void actionTurnRight(Tank tank) throws Exception {
        tank.turn(Direction.RIGHT);
        processTurn(tank);
    }

    private void actionTurnLeft(Tank tank) throws Exception {
        tank.turn(Direction.LEFT);
        processTurn(tank);
    }

    private void actionMoveLeft(Tank tank) throws Exception {
        tank.turn(Direction.LEFT);
        processTurn(tank);
        processMove(tank);
    }

    public void findTheTarget(Tank tank) {
        if (tank == null) {
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
        } else {
            targetX = tank.getX() / cellSize;
            targetY = tank.getY() / cellSize;
        }
    }

    public void scanRightAndDown(Tank tank) throws Exception {
        int ytank = tank.getY() / cellSize;
        int xtank = tank.getX() / cellSize;

        if (xtank == targetX) {
            for (int y = ytank; y < targetY; y++) {
                if (battleField.scanQuadrant(y + 1, xtank) instanceof Rock || battleField.scanQuadrant(y + 1, xtank) instanceof Brick || battleField.scanQuadrant(y + 1, xtank) instanceof Eagle) {
                    actionTurnDown(tank);
                    actionFire(tank);
                    return;
                }
            }
        }

        if (ytank == targetY) {
            for (int x = xtank; x < targetX; x++) {
                if (battleField.scanQuadrant(ytank, x + 1) instanceof Rock || battleField.scanQuadrant(ytank, x + 1) instanceof Brick || battleField.scanQuadrant(ytank, x + 1) instanceof Eagle) {
                    actionTurnRight(tank);
                    actionFire(tank);
                    return;
                }
            }
        }

        if (battleField.scanQuadrant(ytank, xtank + 1) instanceof Rock || battleField.scanQuadrant(ytank, xtank + 1) instanceof Brick || battleField.scanQuadrant(ytank, xtank + 1) instanceof Eagle) {
            actionTurnRight(tank);
            actionFire(tank);
            actionMoveRight(tank);
        } else if (battleField.scanQuadrant(ytank, xtank + 1) instanceof CapBrick) {
            actionTurnRight(tank);
            actionMoveRight(tank);
        } else {
            if (battleField.scanQuadrant(ytank + 1, xtank) instanceof Rock || battleField.scanQuadrant(ytank + 1, xtank) instanceof Brick || battleField.scanQuadrant(ytank + 1, xtank) instanceof Eagle) {
                actionTurnDown(tank);
                actionFire(tank);
                actionMoveDown(tank);
            } else if (battleField.scanQuadrant(ytank + 1, xtank) instanceof CapBrick) {
                actionTurnDown(tank);
                actionMoveDown(tank);
            }
        }
    }

    public void scanLeftAndDown(Tank tank) throws Exception {
        int ytank = tank.getY() / cellSize;
        int xtank = tank.getX() / cellSize;

        if (xtank == targetX) {
            for (int y = ytank; y < targetY; y++) {
                if (battleField.scanQuadrant(y + 1, xtank) instanceof Rock || battleField.scanQuadrant(y + 1, xtank) instanceof Brick || battleField.scanQuadrant(y + 1, xtank) instanceof Eagle) {
                    actionTurnDown(tank);
                    actionFire(tank);
                    return;
                }
            }
        }

        if (ytank == targetY) {
            for (int x = xtank; x > targetX; x--) {
                if (battleField.scanQuadrant(ytank, x - 1) instanceof Rock || battleField.scanQuadrant(ytank, x - 1) instanceof Brick || battleField.scanQuadrant(ytank, x - 1) instanceof Eagle) {
                    actionTurnLeft(tank);
                    actionFire(tank);
                    return;
                }
            }
        }

        if (battleField.scanQuadrant(ytank, xtank - 1) instanceof Rock || battleField.scanQuadrant(ytank, xtank - 1) instanceof Brick || battleField.scanQuadrant(ytank, xtank - 1) instanceof Eagle) {
            actionTurnLeft(tank);
            actionFire(tank);
            actionMoveLeft(tank);
        } else if (battleField.scanQuadrant(ytank, xtank - 1) instanceof CapBrick) {
            actionTurnLeft(tank);
            actionMoveLeft(tank);
        } else {
            if (battleField.scanQuadrant(ytank + 1, xtank) instanceof Rock || battleField.scanQuadrant(ytank + 1, xtank) instanceof Brick || battleField.scanQuadrant(ytank + 1, xtank) instanceof Eagle) {
                actionTurnDown(tank);
                actionFire(tank);
                actionMoveDown(tank);
            } else if (battleField.scanQuadrant(ytank + 1, xtank) instanceof CapBrick) {
                actionTurnDown(tank);
                actionMoveDown(tank);
            }
        }
    }

    public void scanLeftAndUp(Tank tank) throws Exception {
        int ytank = tank.getY() / cellSize;
        int xtank = tank.getX() / cellSize;

        if (xtank == targetX) {
            for (int y = ytank; y > targetY; y--) {
                if (battleField.scanQuadrant(y - 1, xtank) instanceof Rock || battleField.scanQuadrant(y - 1, xtank) instanceof Brick || battleField.scanQuadrant(y - 1, xtank) instanceof Eagle) {
                    actionTurnUp(tank);
                    actionFire(tank);
                    return;
                }
            }
        }

        if (ytank == targetY) {
            for (int x = xtank; x > targetX; x--) {
                if (battleField.scanQuadrant(ytank, x - 1) instanceof Rock || battleField.scanQuadrant(ytank, x - 1) instanceof Brick || battleField.scanQuadrant(ytank, x - 1) instanceof Eagle) {
                    actionTurnLeft(tank);
                    actionFire(tank);
                    return;
                }
            }
        }

        if (battleField.scanQuadrant(ytank, xtank - 1) instanceof Rock || battleField.scanQuadrant(ytank, xtank - 1) instanceof Brick || battleField.scanQuadrant(ytank, xtank - 1) instanceof Eagle) {
            actionTurnLeft(tank);
            actionFire(tank);
            actionMoveLeft(tank);
        } else if (battleField.scanQuadrant(ytank, xtank - 1) instanceof CapBrick) {
            actionTurnLeft(tank);
            actionMoveLeft(tank);
        } else {
            if (battleField.scanQuadrant(ytank - 1, xtank) instanceof Rock || battleField.scanQuadrant(ytank - 1, xtank) instanceof Brick || battleField.scanQuadrant(ytank - 1, xtank) instanceof Eagle) {
                actionTurnUp(tank);
                actionFire(tank);
                actionMoveUp(tank);
            } else if (battleField.scanQuadrant(ytank - 1, xtank) instanceof CapBrick) {
                actionTurnUp(tank);
                actionMoveUp(tank);
            }
        }
    }

    public void scanRightAndUp(Tank tank) throws Exception {
        int ytank = tank.getY() / cellSize;
        int xtank = tank.getX() / cellSize;

        if (xtank == targetX) {
            for (int y = ytank; y > targetY; y--) {
                if (battleField.scanQuadrant(y - 1, xtank) instanceof Rock || battleField.scanQuadrant(y - 1, xtank) instanceof Brick || battleField.scanQuadrant(y - 1, xtank) instanceof Eagle) {
                    actionTurnUp(tank);
                    actionFire(tank);
                    return;
                }
            }
        }

        if (ytank == targetY) {
            for (int x = xtank; x < targetX; x++) {
                if (battleField.scanQuadrant(ytank, x + 1) instanceof Rock || battleField.scanQuadrant(ytank, x + 1) instanceof Brick || battleField.scanQuadrant(ytank, x + 1) instanceof Eagle) {
                    actionTurnRight(tank);
                    actionFire(tank);
                    return;
                }
            }
        }

        if (battleField.scanQuadrant(ytank, xtank + 1) instanceof Rock || battleField.scanQuadrant(ytank, xtank + 1) instanceof Brick || battleField.scanQuadrant(ytank, xtank + 1) instanceof Eagle) {
            actionTurnRight(tank);
            actionFire(tank);
            actionMoveRight(tank);
        } else if (battleField.scanQuadrant(ytank, xtank + 1) instanceof CapBrick) {
            actionTurnRight(tank);
            actionMoveRight(tank);
        } else {
            if (battleField.scanQuadrant(ytank - 1, xtank) instanceof Rock || battleField.scanQuadrant(ytank - 1, xtank) instanceof Brick || battleField.scanQuadrant(ytank - 1, xtank) instanceof Eagle) {
                actionTurnUp(tank);
                actionFire(tank);
                actionMoveUp(tank);
            } else if (battleField.scanQuadrant(ytank - 1, xtank) instanceof CapBrick) {
                actionTurnUp(tank);
                actionMoveUp(tank);
            }
        }
    }

    private void processAction(Action action, Tank tank) throws Exception {
        if (action == Action.FIRE) {
            processFire(tank.fire());
        } else if (action == Action.MOVEUP) {
            tank.turn(Direction.UP);
            processTurn(tank);
            processMove(tank);
        } else if (action == Action.MOVEDOWN) {
            tank.turn(Direction.DOWN);
            processTurn(tank);
            processMove(tank);
        } else if (action == Action.MOVELEFT) {
            tank.turn(Direction.LEFT);
            processTurn(tank);
            processMove(tank);
        } else if (action == Action.MOVERIGHT) {
            tank.turn(Direction.RIGHT);
            processTurn(tank);
            processMove(tank);
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

    public String getQuadrantXY(int x, int y) {
        return y / cellSize + "_" + x / cellSize;
    }

    public ActionField() throws Exception {
        battleField = new BattleField();
        defender = new T34Defender(0, 0, Direction.DOWN, battleField);
        agressor = new Tiger(448, 256, Direction.DOWN, battleField, 1);
        bullet = new Bullet(-100, -100, Direction.STOP);

        JFrame frame = new JFrame("BATTLECITY");
        setSize(700, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(700, 445));


        Panel startPanel = new Panel();
        startPanel.setLayout(new GridBagLayout());

        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("NEW GAME");

        JMenuItem t34 = new JMenuItem("T34");
        t34.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createGamePanel(startPanel, frame);
                isRunDefender = true;
            }
        });

        JMenuItem tiger = new JMenuItem("TIGER");
        tiger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createGamePanel(startPanel, frame);
                isRunAgressor = true;
            }
        });

        jMenu.add(t34);
        jMenu.addSeparator();
        jMenu.add(tiger);
        jMenuBar.add(jMenu);

        frame.setJMenuBar(jMenuBar);
        frame.add(this);
        frame.add(startPanel);
        frame.setResizable(false);
        frame.pack();
        setVisible(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private void createGamePanel(Panel startPanel, JFrame frame) {
        startPanel.setVisible(false);
        setVisible(true);
        frame.setPreferredSize(new Dimension(battleField.getBF_WIDTH() + 6, battleField.getBF_HEIGHT() + 52));
        frame.pack();
        frame.setLocationRelativeTo(null);
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
