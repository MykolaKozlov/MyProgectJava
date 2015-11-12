package SecondLesson.HomeWork.Tank;

public class BattleField {
    private int BF_WIDTH = 576;
    private int BF_HEIGHT = 576;
    private String[][] battleField = {{" ", "B", "B", " ", "B", "B", " ", "B", " "},
            {"B", " ", "B", " ", " ", "B", " ", " ", "B"},
            {" ", " ", " ", " ", " ", "B", " ", "B", " "},
            {" ", " ", "B", " ", " ", "B", "B", "B", " "},
            {"B", " ", " ", " ", " ", "B", " ", " ", " "},
            {" ", " ", " ", "B", " ", "B", " ", "B", " "},
            {"B", " ", "B", " ", " ", "B", " ", " ", " "},
            {" ", "B", " ", " ", " ", "B", " ", " ", " "},
            {" ", "B", " ", "B", " ", "B", " ", " ", " "}};


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
}
