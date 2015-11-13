package SecondLesson.HomeWork.TigerArmor;

public class Tiger extends Tank {
    protected int armor;

    public Tiger(int x, int y, Direction direction, ActionField actionField, BattleField battleField, int armor) {
        super(x, y, direction, actionField, battleField);
        this.armor = armor;
    }

    @Override
    public void destroy() {
        if (armor == 0){
            super.destroy();
        }
        armor --;
    }
}
