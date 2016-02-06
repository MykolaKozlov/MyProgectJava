package SevenLesson.Chapter_1_Task_1;

public class Motorcycle {

    private MotorcycleModel motorcycleModel;
    private MotorcycleColour motorcycleColour;
    private int price;

    public Motorcycle() {

    }

    public MotorcycleModel getMotorcycleModel() {
        return motorcycleModel;
    }

    public void setMotorcycleModel(MotorcycleModel motorcycleModel) {
        this.motorcycleModel = motorcycleModel;
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
}
