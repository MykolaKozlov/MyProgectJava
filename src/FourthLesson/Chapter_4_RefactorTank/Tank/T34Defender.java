package FourthLesson.Chapter_4_RefactorTank.Tank;

import FourthLesson.Chapter_4_RefactorTank.Action.ActionField;
import FourthLesson.Chapter_4_RefactorTank.Action.Direction;
import FourthLesson.Chapter_4_RefactorTank.Battlefield.BattleField;
import FourthLesson.Chapter_4_RefactorTank.Tank.AbstractTank;

public class T34Defender extends AbstractTank {

    public T34Defender(ActionField actionField, BattleField battleField) {
        super(actionField, battleField);
    }

    public T34Defender(int x, int y, Direction direction, ActionField actionField, BattleField battleField) {
        super(x, y, direction, actionField, battleField);
    }
}
