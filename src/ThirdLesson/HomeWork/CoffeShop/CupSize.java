package ThirdLesson.HomeWork.CoffeShop;

public enum CupSize {
    SMALL_SIZE(0.2), MIDDLE_SIZE(0.3), BIG_SIZE(0.4);

    private double id;

    private CupSize(double id) {
        this.id = id;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }
}
