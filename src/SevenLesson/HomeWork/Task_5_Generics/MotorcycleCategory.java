package SevenLesson.HomeWork.Task_5_Generics;

public enum MotorcycleCategory {
    CLASSIC(0), SPORTBIKE(1), TURIST(2), MINIBIKE(3);

    private int id;

    private MotorcycleCategory(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
