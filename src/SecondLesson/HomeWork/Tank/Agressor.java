package SecondLesson.HomeWork.Tank;

public class Agressor extends Tank{


    public Agressor(int x, int y, Direction direction, ActionField actionField, BattleField battleField) {
        super(x, y, direction, actionField, battleField);
    }

    public Agressor(ActionField actionField, BattleField battleField) {
        super(actionField, battleField);
    }
}
