package SecondLesson.HomeWork.MotoShopServiseClass;

public class Purchase extends Client{
    private double price;
    private Motorcycle motorcycle;
    private String date;

    public Purchase(){

    }

    public Purchase(double price, Motorcycle motorcycle, String date){
        this.price = price;
        this.motorcycle = motorcycle;
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public Motorcycle getMotorcycle() {
        return motorcycle;
    }

    public String getDate() {
        return date;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMotorcycle(Motorcycle motorcycle) {
        this.motorcycle = motorcycle;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
