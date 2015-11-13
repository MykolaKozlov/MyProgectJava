package SecondLesson.HomeWork.DestroyAgressor;

public class Tiger extends Tank {
    protected int armor;


    public Tiger(int x, int y, Direction direction, ActionField actionField, BattleField battleField) {
        super(x, y, direction, actionField, battleField);
    }

    public Tiger(int x, int y, Direction direction, ActionField actionField, BattleField battleField, int armor) {
        super(x, y, direction, actionField, battleField);
        this.armor = armor;
    }
}
