package ThirdLesson.Chapter_4_Tank;

public class T34Defender extends AbstractTank {

    public T34Defender(ActionField actionField, BattleField battleField) {
        super(actionField, battleField);
    }

    public T34Defender(int x, int y, Direction direction, ActionField actionField, BattleField battleField) {
        super(x, y, direction, actionField, battleField);
    }
}
