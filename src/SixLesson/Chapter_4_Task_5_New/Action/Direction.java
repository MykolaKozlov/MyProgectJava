package SixLesson.Chapter_4_Task_5_New.Action;

public enum Direction {
    UP(0), DOWN(1), LEFT(2), RIGHT(3), STOP(4);

    private int id;

    private Direction(int id) {

    }

    public int getId() {
        return id;
    }
}
