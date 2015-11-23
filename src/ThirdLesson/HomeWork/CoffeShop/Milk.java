package ThirdLesson.HomeWork.CoffeShop;

public enum Milk {
    NONE(0), MILK(0.2);

    private double id;

    private Milk(double id) {
        this.id = id;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }
}
