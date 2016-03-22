package EightLesson.Homework.Tank;

public enum Action {
    NONE(0), MOVEUP(1), MOVEDOWN(2), MOVELEFT(3), MOVERIGHT(4), FIRE(5), TURNUP(6), TURNDOWN(7), TURNLEFT(8), TURNRIGHT(9);

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
