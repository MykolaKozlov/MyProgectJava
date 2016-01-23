package SixLesson.Chapter_2_Task_6;

public class Subscriber implements Observer {

    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void handleEvent(String name, int number) {
        System.out.println("Name of subscriber: " + this.name + " ; " + "Name of product: " + name + " ; " + "Number of product: " + number);
    }
}
