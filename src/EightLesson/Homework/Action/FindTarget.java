package EightLesson.Homework.Action;

import EightLesson.Homework.Battlefield.*;
import EightLesson.Homework.Tank.Action;
import EightLesson.Homework.Tank.Tank;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindTarget {

    private BattleField battleField;

    private int[][] numberBattleFiel;
    private Deque<Action> way;
    private int cellSize = 64;

    private int targetX = 0;
    private int targetY = 0;
    private boolean findTarget = false;

    public FindTarget() {
        numberBattleFiel = new int[9][9];
        way = new ArrayDeque<>();
        battleField = new BattleField();
    }

    public BattleField getBattleField() {
        return battleField;
    }

    public void setBattleField(BattleField battleField) {
        this.battleField = battleField;
    }

    public int[][] getNumberBattleFiel() {
        return numberBattleFiel;
    }

    public void setNumberBattleFiel(int[][] numberBattleFiel) {
        this.numberBattleFiel = numberBattleFiel;
    }

    public Deque<Action> getWay() {
        return way;
    }

    public void setWay(Deque<Action> way) {
        this.way = way;
    }

    public int getCellSize() {
        return cellSize;
    }

    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }

    public int getTargetX() {
        return targetX;
    }

    public void setTargetX(int targetX) {
        this.targetX = targetX;
    }

    public int getTargetY() {
        return targetY;
    }

    public void setTargetY(int targetY) {
        this.targetY = targetY;
    }

    public boolean isFindTarget() {
        return findTarget;
    }

    public void setFindTarget(boolean findTarget) {
        this.findTarget = findTarget;
    }


    private void checkBattleFieldObject(AbstractBattleFieldObject[][] object) {
//        -1 - CapBrick, Brick, Eagle and Rock;
//        -2 - Water
        for (int i = 0; i < object.length; i++) {
            for (int j = 0; j < object[i].length; j++) {
                if (object[i][j] instanceof CapBrick || object[i][j] instanceof Brick || object[i][j] instanceof Eagle || object[i][j] instanceof Rock) {
                    numberBattleFiel[i][j] = -1;
                } else {
                    numberBattleFiel[i][j] = -2;
                }
            }
        }
    }


    public void runWave(AbstractBattleFieldObject[][] object, int[][] battleField, Tank attackTank, Object target) {
        checkBattleFieldObject(object);
        findTheTarget(target);
        if (!attackTank.isDestroyed()) {
            battleField[attackTank.getY() / 64][attackTank.getX() / 64] = 0;
        }
        int position = 0;
        while (position < 100) {
            for (int i = 0; i < battleField.length; i++) {
                for (int j = 0; j < battleField[i].length; j++) {
                    if (battleField[i][j] == position) {
                        checkPosition(j, i, battleField);
                    }
                }
            }
            position++;
        }
        way.removeAll(way);
        buildWayToTheTarget(targetX, targetY, battleField);
    }

    public void checkPosition(int x, int y, int[][] battleField) {
        int position = battleField[y][x];
        checkUp(x, y, position, battleField);
        checkRight(x, y, position, battleField);
        checkDown(x, y, position, battleField);
        checkLeft(x, y, position, battleField);
    }


    private void checkUp(int x, int y, int position, int[][] battleField) {
        if (y != 0) {
            if (battleField[y - 1][x] == -1) {
                battleField[y - 1][x] = position + 1;
            }
        }
    }

    private void checkRight(int x, int y, int position, int[][] battleField) {
        if (x != 8) {
            if (battleField[y][x + 1] == -1) {
                battleField[y][x + 1] = position + 1;
            }
        }
    }

    private void checkDown(int x, int y, int position, int[][] battleField) {
        if (y != 8) {
            if (battleField[y + 1][x] == -1) {
                battleField[y + 1][x] = position + 1;
            }
        }
    }

    private void checkLeft(int x, int y, int position, int[][] battleField) {
        if (x != 0) {
            if (battleField[y][x - 1] == -1) {
                battleField[y][x - 1] = position + 1;
            }
        }
    }


    public void buildWayToTheTarget(int x, int y, int[][] battleField) {
        int position = battleField[y][x];
        scanUp(x, y, position, battleField);
        scanRight(x, y, position, battleField);
        scanDown(x, y, position, battleField);
        scanLeft(x, y, position, battleField);
    }

    private void scanUp(int x, int y, int position, int[][] battleField) {
        if (y != 0) {
            if (battleField[y - 1][x] == position - 1 && findTarget == false) {
                way.offerFirst(Action.MOVEDOWN);
                buildWayToTheTarget(x, y - 1, battleField);
            }
            if (battleField[y - 1][x] == 0) {
                findTarget = true;
            }
        }
    }

    private void scanRight(int x, int y, int position, int[][] battleField) {
        if (x != 8) {
            if (battleField[y][x + 1] == position - 1 && findTarget == false) {
                way.offerFirst(Action.MOVELEFT);
                buildWayToTheTarget(x + 1, y, battleField);
            }
            if (battleField[y][x + 1] == 0) {
                findTarget = true;
            }
        }
    }

    private void scanDown(int x, int y, int position, int[][] battleField) {
        if (y != 8) {
            if (battleField[y + 1][x] == position - 1 && findTarget == false) {
                way.offerFirst(Action.MOVEUP);
                buildWayToTheTarget(x, y + 1, battleField);
            }
            if (battleField[y + 1][x] == 0) {
                findTarget = true;
            }
        }
    }

    private void scanLeft(int x, int y, int position, int[][] battleField) {
        if (x != 0) {
            if (battleField[y][x - 1] == position - 1 && findTarget == false) {
                way.offerFirst(Action.MOVERIGHT);
                buildWayToTheTarget(x - 1, y, battleField);
            }
            if (battleField[y][x - 1] == 0) {
                findTarget = true;
            }
        }
    }

    public void findTheTarget(Object o) {
        if (o.equals("Eagle")) {
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
        } else if (o instanceof Tank) {
            targetY = ((Tank) o).getY() / cellSize;
            targetX = ((Tank) o).getX() / cellSize;
        }

    }
}
