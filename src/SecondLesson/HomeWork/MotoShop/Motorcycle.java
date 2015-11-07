package SecondLesson.HomeWork.MotoShop;

public class Motorcycle {
    private MotorcycleBrand motorcycleBrand;
    private MotorcycleColour motorcycleColour;
    private double weight;
    private int length;
    private String number;
    private int engineCapacity;
    private int maxSpeed;
    private int fuelTank;
    private int power;
    private double price;

    public Motorcycle() {

    }

    public double getPrice() {
        return price;
    }

    public MotorcycleBrand getMotorcycleBrand() {
        return motorcycleBrand;
    }

    public MotorcycleColour getMotorcycleColour() {
        return motorcycleColour;
    }

    public double getWeight() {
        return weight;
    }

    public int getLength() {
        return length;
    }

    public String getNumber() {
        return number;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getFuelTank() {
        return fuelTank;
    }

    public int getPower() {
        return power;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMotorcycleBrand(MotorcycleBrand motorcycleBrand) {
        this.motorcycleBrand = motorcycleBrand;
    }

    public void setMotorcycleColour(MotorcycleColour motorcycleColour) {
        this.motorcycleColour = motorcycleColour;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setFuelTank(int fuelTank) {
        this.fuelTank = fuelTank;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
