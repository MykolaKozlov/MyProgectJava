package SecondLesson.HomeWork.TigerArmor;

public class BT7 extends Tank {

    public BT7(int x, int y, Direction direction, ActionField actionField, BattleField battleField) {
        super(x, y, direction, actionField, battleField);
        this.speed = super.speed * 2;
    }

}
