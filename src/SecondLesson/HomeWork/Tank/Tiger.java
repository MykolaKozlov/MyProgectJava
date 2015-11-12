package SecondLesson.HomeWork.Tank;

public class Tiger extends Tank {
    protected int armor;

    public Tiger(int x, int y, Direction direction, ActionField actionField, BattleField battleField, int armor) {
        super(x, y, direction, actionField, battleField);
        this.armor = armor;
    }
}
