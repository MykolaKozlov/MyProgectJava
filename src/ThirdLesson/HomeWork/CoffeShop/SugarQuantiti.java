package ThirdLesson.HomeWork.CoffeShop;

public enum SugarQuantiti {
    NONE(0), ONE(0.1), TWO(0.2), THREE(0.3), FOUR(0.4), FIVE(0.5);

    private double id;

    private SugarQuantiti(double id) {
        this.id = id;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }
}
