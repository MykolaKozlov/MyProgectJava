package FourthLesson.HomeWork.AttackTank.Battlefield;

import ThirdLesson.Chapter_4_Tank.Drowable;

import java.awt.*;

public class BattleField implements Drowable {
    private int BF_WIDTH = 576;
    private int BF_HEIGHT = 576;
    private boolean COLORDED_MODE = false;
    private int xLength = 9;
    private int yLength = 9;

    private String[][] testBattleField = {
            {" ", "R", "R", "R", "R", "R", "R", "R", " "},
            {" ", " ", "B", " ", "W", " ", "B", " ", " "},
            {" ", " ", " ", " ", "W", " ", " ", " ", " "},
            {" ", " ", " ", " ", "B", " ", " ", " ", " "},
            {"B", " ", " ", " ", "W", " ", " ", " ", " "},
            {" ", " ", " ", " ", "W", " ", " ", " ", " "},
            {"B", " ", " ", " ", "B", " ", " ", " ", " "},
            {"B", " ", " ", "R", "R", "R", " ", " ", " "},
            {" ", "B", "B", "R", "E", "R", "B", "B", " "}};

    public AbstractBattleFieldObject[][] battleFieldObjects = new AbstractBattleFieldObject[xLength][yLength];

    public void addObject() {
        for (int i = 0; i < testBattleField.length; i++) {
            for (int j = 0; j < testBattleField[i].length; j++) {
                if (testBattleField[i][j] == (" ")) {
                    battleFieldObjects[i][j] = new CapBrick(j * 64, i * 64);
                }
                if (testBattleField[i][j] == ("R")) {
                    battleFieldObjects[i][j] = new Rock(j * 64, i * 64);
                }
                if (testBattleField[i][j] == ("B")) {
                    battleFieldObjects[i][j] = new Brick(j * 64, i * 64);
                }
                if (testBattleField[i][j] == ("W")) {
                    battleFieldObjects[i][j] = new Water(j * 64, i * 64);
                }
                if (testBattleField[i][j] == ("E")) {
                    battleFieldObjects[i][j] = new Eagle(j * 64, i * 64);
                }
            }
        }
    }

    public AbstractBattleFieldObject scanQuadrant(int v, int h) {
        return battleFieldObjects[v][h];
    }

    public void updateQuadrant(int v, int h, CapBrick capBrick) {
        battleFieldObjects[v][h] = capBrick;
    }

    public void destroyObject(int v, int h) {
        battleFieldObjects[v][h].destroy();
    }

    public int getDimentionX() {
        return battleFieldObjects.length;
    }

    public int getDimentionY() {
        return battleFieldObjects.length;
    }

    public BattleField() {
        addObject();
    }

    public BattleField(AbstractBattleFieldObject[][] battleFieldObjects) {
        this.battleFieldObjects = battleFieldObjects;
    }

    public int getBF_WIDTH() {
        return BF_WIDTH;
    }

    public int getBF_HEIGHT() {
        return BF_HEIGHT;
    }

    public AbstractBattleFieldObject[][] getAbstractBattleFieldObject() {
        return battleFieldObjects;
    }

    @Override
    public void draw(Graphics graphics) {
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
                graphics.setColor(cc);
                graphics.fillRect(h * 64, v * 64, 64, 64);
            }
        }

        for (int j = 0; j < battleFieldObjects.length; j++) {
            for (int k = 0; k < battleFieldObjects[j].length; k++) {
                battleFieldObjects[j][k].draw(graphics);
            }
        }
    }
}
