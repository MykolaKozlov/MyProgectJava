package ThirdLesson.HomeWork.CoffeShop;

public enum CoffeeSort {
    ARABICA_SANTOS(0.1), ARABICA_TARRUSA(0.1), ARABICA_MOCCA(0.2), ARABICA_KONA(0.2), ARABICA_KHARAR(0.3);

    private double id;

    private CoffeeSort(double id) {
        this.id = id;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }
}
