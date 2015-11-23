package ThirdLesson.HomeWork.CoffeShop;

public enum Additives {
    NONE(0), CINNAMON(0.3), CHOCOLATE(0.4);

    private double id;

    private Additives(double id) {
        this.id = id;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }
}
