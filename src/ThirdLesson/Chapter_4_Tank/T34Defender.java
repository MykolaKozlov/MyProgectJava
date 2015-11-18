package ThirdLesson.Chapter_4_Tank;

public class T34Defender extends AbstractTank {

    public T34Defender(ActionField actionField, BattleField battleField) {
        super(actionField, battleField);
    }

    public T34Defender(int x, int y, Direction direction, ActionField actionField, BattleField battleField) {
        super(x, y, direction, actionField, battleField);
    }

    @Override
    public void updateX(int x) {
        super.updateX(x);
    }

    @Override
    public void updateY(int y) {
        super.updateY(y);
    }

    @Override
    public int getSpeed() {
        return super.getSpeed();
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public Direction getDirection() {
        return super.getDirection();
    }

    @Override
    public ActionField getActionField() {
        return super.getActionField();
    }

    @Override
    public BattleField getBattleField() {
        return super.getBattleField();
    }

    @Override
    public void turn(Direction direction) throws Exception {
        super.turn(direction);
    }

    @Override
    public void move() throws Exception {
        super.move();
    }

    @Override
    public void fire() throws Exception {
        super.fire();
    }

    @Override
    public void moveToQuadrant(int v, int h) throws Exception {
        super.moveToQuadrant(v, h);
    }

    @Override
    public int random() {
        return super.random();
    }

    @Override
    void clean() throws Exception {
        super.clean();
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
