package FourthLesson.HomeWork.AttackTank.Tank;

public enum Action {
    NONE(0), MOVE(1), FIRE(2), TURN(3), UP(4), DOWN(5), LEFT(6), RIGHT(7);

    private int id;

    private Action(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
