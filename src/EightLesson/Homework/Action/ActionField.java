package EightLesson.Homework.Action;

import EightLesson.Homework.Battlefield.*;
import EightLesson.Homework.Tank.Action;
import EightLesson.Homework.Tank.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class ActionField extends JPanel {

    private int step = 1;
    private int minimumFieldSize = 0;
    private int maximumFieldSize = 512;
    private int cellSize = 64;
    private BattleField battleField;
    private Tank defender;
    private Tank agressor;
    private Bullet bullet;

    private File defenderActions;
    private File agressorActions;
    private int gameCounter = 1;

    private boolean isRunAgressor = false;
    private boolean isRunDefender = false;
    private boolean agressorDestroy = false;
    private boolean defenderDestroy = false;

//    private boolean findTarget = false;


    private PanelEnd panelEnd;
    private JFrame frame;
    private JLabel tankWin;

    public ActionField() throws Exception {
        defenderActions = new File("D:\\MyProgectJava\\Catalog\\EightLesson\\Homework\\Task_2\\defenderActions.txt");
        agressorActions = new File("D:\\MyProgectJava\\Catalog\\EightLesson\\Homework\\Task_2\\agressorActions.txt");
        battleField = new BattleField();
        defender = new T34Defender(0, 0, Direction.DOWN, battleField);
        agressor = new Tiger(512, 0, Direction.DOWN, battleField, 0);
        bullet = new Bullet(-100, -100, Direction.STOP);

        frame = new JFrame("BATTLECITY");
        setSize(700, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(700, 445));


        PanelStart startPanelStart = new PanelStart();
        startPanelStart.setLayout(new GridBagLayout());

        panelEnd = new PanelEnd();
        panelEnd.setLayout(new GridBagLayout());

        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("NEW GAME");

        JMenuItem t34 = new JMenuItem("T34");
        t34.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writeGameNumber();
                isRunDefender = true;
                createGamePanel(startPanelStart, frame);

            }
        });

        JMenuItem tiger = new JMenuItem("TIGER");
        tiger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writeGameNumber();
                isRunAgressor = true;
                createGamePanel(startPanelStart, frame);

            }
        });

        tankWin = new JLabel();
        tankWin.setForeground(Color.WHITE);
        tankWin.setFont(new Font("ARIAL", Font.BOLD, 50));

        JButton playAgain = new JButton("PLAY AGAIN");
        playAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createStartPanel(startPanelStart);
            }
        });

        panelEnd.add(playAgain, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(100, 10, 10, 10), 0, 0));
        panelEnd.add(tankWin, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 150, 10), 0, 0));

        jMenu.add(t34);
        jMenu.addSeparator();
        jMenu.add(tiger);
        jMenuBar.add(jMenu);

        frame.setJMenuBar(jMenuBar);
        frame.add(startPanelStart);

        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

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


    private void checkObgectForFire(int x, int y, Tank tank, Tank target) throws Exception {
        if (this.battleField.scanQuadrant(y, x) instanceof Brick || this.battleField.scanQuadrant(y, x) instanceof Rock || this.battleField.scanQuadrant(y, x) instanceof Eagle || (target.getX() / 64 == x && target.getY() / 64 == y)) {
            processFire(tank.fire());
            writeAction(Action.FIRE, tank);
        }
    }

    public void runTheGame() throws Exception {
        FindTarget defenderAttack = new FindTarget();
        FindTarget agressorAttack = new FindTarget();
        defenderActions.delete();
        agressorActions.delete();


        while (true) {
            Thread.sleep(10);

            if (!agressor.isDestroyed() && !defender.isDestroyed() && isRunDefender) {

                defenderAttack.setFindTarget(false);
                defenderAttack.runWave(battleField.getAbstractBattleFieldObject(), defenderAttack.getNumberBattleFiel(), defender, agressor);
                processAction(defenderAttack.getWay().poll(), defender, agressor);

            }
            if (!agressor.isDestroyed() && !defender.isDestroyed() && isRunDefender) {
                agressorAttack.setFindTarget(false);
                agressorAttack.runWave(battleField.getAbstractBattleFieldObject(), agressorAttack.getNumberBattleFiel(), agressor, "Eagle");
                processAction(agressorAttack.getWay().poll(), agressor, defender);

            }


            if (!agressor.isDestroyed() && !defender.isDestroyed() && isRunAgressor) {
                agressorAttack.setFindTarget(false);
                agressorAttack.runWave(battleField.getAbstractBattleFieldObject(), agressorAttack.getNumberBattleFiel(), agressor, defender);
                processAction(agressorAttack.getWay().poll(), agressor, defender);
            }
            if (!agressor.isDestroyed() && !defender.isDestroyed() && isRunAgressor) {

                defenderAttack.setFindTarget(false);
                defenderAttack.runWave(battleField.getAbstractBattleFieldObject(), defenderAttack.getNumberBattleFiel(), defender, agressor);
                processAction(defenderAttack.getWay().poll(), defender, agressor);
            }


            if (defender.isDestroyed() && (isRunDefender || isRunAgressor)) {
                tankWin.setText("TIGER WIN");
                createEndPanel(panelEnd, frame);
                isRunDefender = false;
                isRunAgressor = false;
                defenderDestroy = true;

            }
            if (agressor.isDestroyed() && (isRunAgressor || isRunDefender)) {
                tankWin.setText("T34 WIN");
                createEndPanel(panelEnd, frame);
                isRunAgressor = false;
                isRunDefender = false;
                agressorDestroy = true;
            }
        }

    }

    private void processAction(Action action, Tank tank, Tank target) throws Exception {
        writeAction(action, tank);
        if (action == Action.FIRE) {
            processFire(tank.fire());
        } else if (action == Action.MOVEUP) {
            tank.turn(Direction.UP);
            processTurn(tank);
            checkObgectForFire(tank.getX() / 64, tank.getY() / 64 - 1, tank, target);
            processMove(tank);
        } else if (action == Action.MOVEDOWN) {
            tank.turn(Direction.DOWN);
            processTurn(tank);
            checkObgectForFire(tank.getX() / 64, tank.getY() / 64 + 1, tank, target);
            processMove(tank);
        } else if (action == Action.MOVELEFT) {
            tank.turn(Direction.LEFT);
            processTurn(tank);
            checkObgectForFire(tank.getX() / 64 - 1, tank.getY() / 64, tank, target);
            processMove(tank);
        } else if (action == Action.MOVERIGHT) {
            tank.turn(Direction.RIGHT);
            processTurn(tank);
            checkObgectForFire(tank.getX() / 64 + 1, tank.getY() / 64, tank, target);
            processMove(tank);
        }
    }

    private void writeAction(Action action, Tank tank) {
        String str = action.toString();

        try (BufferedWriter writeDefender = new BufferedWriter(new FileWriter(defenderActions, true));
             BufferedWriter writeAgressor = new BufferedWriter(new FileWriter(agressorActions, true))) {

            if (tank instanceof T34Defender) {
                writeDefender.newLine();
                writeDefender.write(str);
            } else {
                writeAgressor.newLine();
                writeAgressor.write(str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeGameNumber() {
        String str = "GAME №" + gameCounter;

        try (BufferedWriter writeDefender = new BufferedWriter(new FileWriter(defenderActions, true));
             BufferedWriter writeAgressor = new BufferedWriter(new FileWriter(agressorActions, true))) {
            writeDefender.newLine();
            writeDefender.write(str);
            writeAgressor.newLine();
            writeAgressor.write(str);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        gameCounter++;
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

    private void createGamePanel(PanelStart startPanelStart, JFrame frame) {
        frame.remove(startPanelStart);
        frame.add(this);
        frame.setPreferredSize(new Dimension(battleField.getBF_WIDTH() + 6, battleField.getBF_HEIGHT() + 52));
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    private void createEndPanel(PanelEnd panelEnd, JFrame frame) {
        frame.remove(this);
        frame.add(panelEnd);
        frame.setPreferredSize(new Dimension(726, 457));
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    private void createStartPanel(PanelStart startPanelStart) {
        frame.remove(panelEnd);
        frame.add(startPanelStart);
        frame.setPreferredSize(new Dimension(700, 445));
        frame.pack();
        frame.setLocationRelativeTo(null);

        battleField = new BattleField();

        if (agressorDestroy) {
            defender = new T34Defender(0, 0, Direction.DOWN, battleField);
            agressor = new Tiger(512, 0, Direction.DOWN, battleField, 0);
        }
        if (defenderDestroy) {
            defender = new T34Defender(0, 0, Direction.DOWN, battleField);
            agressor = new Tiger(512, 0, Direction.DOWN, battleField, 0);
        }
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
