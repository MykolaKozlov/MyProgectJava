package ThirdLesson.HomeWork.CoffeShop;

public enum TeaSort {
    GREEN_TEA(0.1), BLACK_TEA(0.2), BERHAMOT_TEA(0.3);

    private double id;

    private TeaSort(double id) {
        this.id = id;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }
}
