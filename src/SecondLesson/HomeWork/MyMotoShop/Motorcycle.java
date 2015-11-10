package SecondLesson.HomeWork.MyMotoShop;

public class Motorcycle {
    private MotorcycleBrand motorcycleBrand;
    private MotorcycleCategory motorcycleCategory;
    private MotorcycleColour motorcycleColour;
    private double price;
    private int quantity;
    private String productNumber;

    public Motorcycle() {

    }

    public MotorcycleBrand getMotorcycleBrand() {
        return motorcycleBrand;
    }

    public void setMotorcycleBrand(MotorcycleBrand motorcycleBrand) {
        this.motorcycleBrand = motorcycleBrand;
    }

    public MotorcycleCategory getMotorcycleCategory() {
        return motorcycleCategory;
    }

    public void setMotorcycleCategory(MotorcycleCategory motorcycleCategory) {
        this.motorcycleCategory = motorcycleCategory;
    }

    public MotorcycleColour getMotorcycleColour() {
        return motorcycleColour;
    }

    public void setMotorcycleColour(MotorcycleColour motorcycleColour) {
        this.motorcycleColour = motorcycleColour;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }
}
