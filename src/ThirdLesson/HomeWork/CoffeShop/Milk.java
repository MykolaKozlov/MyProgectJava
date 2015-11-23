package ThirdLesson.HomeWork.CoffeShop;

public enum Milk {
    MILK(0.1);

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
