package SecondLesson.HomeWork.MotoShopServiseClass;

public class Motorcycle {
    private MotorcycleBrand motorcycleBrand;
    private MotorcycleCategory motorcycleCategory;
    private MotorcycleColour motorcycleColour;
    private double price;
    private int quantity;

    public Motorcycle() {

    }

    public double getPrice() {
        return price;
    }

    public MotorcycleBrand getMotorcycleBrand() {
        return motorcycleBrand;
    }

    public MotorcycleCategory getMotorcycleCategory() {
        return motorcycleCategory;
    }

    public MotorcycleColour getMotorcycleColour() {
        return motorcycleColour;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMotorcycleBrand(MotorcycleBrand motorcycleBrand) {
        this.motorcycleBrand = motorcycleBrand;
    }

    public void setMotorcycleCategory(MotorcycleCategory motorcycleCategory) {
        this.motorcycleCategory = motorcycleCategory;
    }

    public void setMotorcycleColour(MotorcycleColour motorcycleColour) {
        this.motorcycleColour = motorcycleColour;
    }
}
