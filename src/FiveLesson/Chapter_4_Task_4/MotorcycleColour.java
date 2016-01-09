package FiveLesson.Chapter_4_Task_4;

public enum MotorcycleColour {
    RED(0), ORANGE(1), GREEN(2), BLUE(3), YELLOW(4), BLACK(5), WHITE(6), GREY(7);

    private int id;

    private MotorcycleColour(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
