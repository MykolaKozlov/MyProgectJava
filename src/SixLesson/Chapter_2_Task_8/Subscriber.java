package SixLesson.Chapter_2_Task_8;

import java.util.Observable;
import java.util.Observer;

public class Subscriber implements Observer {

    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Magazine) {
            System.out.println("Name of subscriber: " + this.name + " ; " + "Name of product: " + ((Magazine) o).getNameMagazine() + " ; " + "Number of product: " + ((Magazine) o).getNumberMagazine());
        } else {
            System.out.println("Name of subscriber: " + this.name + " ; " + "Name of product: " + ((Newspaper) o).getNameNewspaper() + " ; " + "Number of product: " + ((Newspaper) o).getNumberNewspaper());
        }
    }
}
