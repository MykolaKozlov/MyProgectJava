package FiveLesson.Chapter_4_Task_1;

public enum MotorcycleBrand {
    HONDA(0), BMW(1), DUCATI(2), HARLEY_DAVIDSON(3), JAVA(4), KAWASAKI(5), KTM(6), SUZUKI(7), YAMAHA(8);

    private int id;

    private MotorcycleBrand(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
