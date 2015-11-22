package ThirdLesson.HomeWork.SortTank.Tank;

import ThirdLesson.HomeWork.SortTank.Actions.ActionField;
import ThirdLesson.HomeWork.SortTank.Battlefield.BattleField;
import ThirdLesson.HomeWork.SortTank.Actions.Direction;

public class T34Defender extends AbstractTank {

    public T34Defender(ActionField actionField, BattleField battleField) {
        super(actionField, battleField);
    }

    public T34Defender(int x, int y, Direction direction, ActionField actionField, BattleField battleField) {
        super(x, y, direction, actionField, battleField);
    }
}
