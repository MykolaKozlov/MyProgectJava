package ThirdLesson.HomeWork.BattlefieldObjects;

import ThirdLesson.Chapter_4_Tank.Drowable;

import java.awt.*;

public class BattleField implements Drowable {
    private int BF_WIDTH = 576;
    private int BF_HEIGHT = 576;
    private boolean COLORDED_MODE = false;
    private AbstractBattleFieldObject object;

    private String[][] battleField = {
            {" ", "R", "R", "R", "R", "R", "R", "R", " "},
            {" ", " ", "B", " ", "W", " ", "B", " ", " "},
            {" ", " ", " ", " ", "W", " ", " ", " ", " "},
            {" ", " ", " ", " ", "B", " ", " ", " ", " "},
            {" ", " ", " ", " ", "W", " ", " ", " ", " "},
            {" ", " ", " ", " ", "W", " ", " ", " ", " "},
            {" ", " ", " ", " ", "B", " ", " ", " ", " "},
            {" ", " ", " ", "R", "R", "R", " ", " ", " "},
            {" ", "B", "B", "R", "E", "R", "B", "B", " "}};


    public String scanQuadrant(int v, int h) {
        return battleField[v][h];
    }

    public void updateQuadrant(int v, int h, String constant) {
        battleField[v][h] = constant;
    }

    public int getDimentionX() {
        return battleField.length;
    }

    public int getDimentionY() {
        return battleField.length;
    }

    public BattleField() {

    }

    public BattleField(String[][] battleField) {
        this.battleField = battleField;
    }

    public int getBF_WIDTH() {
        return BF_WIDTH;
    }

    public int getBF_HEIGHT() {
        return BF_HEIGHT;
    }

    public String[][] getBattleField() {
        return battleField;
    }

    private String getQuadrant(int v, int h) {
        return (v - 1) * 64 + "_" + (h - 1) * 64;
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

        for (int j = 0; j < getDimentionY(); j++) {
            for (int k = 0; k < getDimentionX(); k++) {
                String coordinates = getQuadrant(j + 1, k + 1);
                int separator = coordinates.indexOf("_");
                int y = Integer.parseInt(coordinates
                        .substring(0, separator));
                int x = Integer.parseInt(coordinates
                        .substring(separator + 1));
                if (scanQuadrant(j, k).equals("B")) {
                    object = new Brick(x, y);
                    object.draw(graphics);
                } else if (scanQuadrant(j, k).equals("R")) {
                    object = new Rock(x, y);
                    object.draw(graphics);
                } else if (scanQuadrant(j, k).equals("W")) {
                    object = new Water(x, y);
                    object.draw(graphics);
                } else if (scanQuadrant(j, k).equals("E")) {
                    object = new Eagle(x, y);
                    object.draw(graphics);
                }
            }
        }
    }
}
