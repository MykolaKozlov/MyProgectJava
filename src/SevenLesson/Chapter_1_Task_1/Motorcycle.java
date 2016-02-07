package SevenLesson.Chapter_1_Task_1;

public class Motorcycle {

    private String brand;
    private String model;
    private MotorcycleColour motorcycleColour;
    private int price;

    public Motorcycle() {

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public MotorcycleColour getMotorcycleColour() {
        return motorcycleColour;
    }

    public void setMotorcycleColour(MotorcycleColour motorcycleColour) {
        this.motorcycleColour = motorcycleColour;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BRAND: " + getBrand() + "; MODEL: " + getModel() + "; COLOUR: " + getMotorcycleColour() + "; PRICE: " + Integer.toString(getPrice()) + ";";
    }
}
