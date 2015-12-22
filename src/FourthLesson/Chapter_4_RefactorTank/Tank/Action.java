package FourthLesson.Chapter_4_RefactorTank.Tank;

public enum Action {
    NONE(0), MOVE(1), FIRE(2), TURN(3);

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
