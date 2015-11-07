package SecondLesson.HomeWork.MotoShop;

public class Purchase {
    private double price;
    private Client client;
    private Motorcycle motorcycle;
    private String date;

    public Purchase(){

    }

    public Purchase(double price, Client client, Motorcycle motorcycle, String date){
        this.price = price;
        this.client = client;
        this.motorcycle = motorcycle;
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public Client getClient() {
        return client;
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

    public void setClient(Client client) {
        this.client = client;
    }

    public void setMotorcycle(Motorcycle motorcycle) {
        this.motorcycle = motorcycle;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
