package SixLesson.Chapter_2_Task_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Newspaper implements Observable {

    private String nameNewspaper = "Mursilka";
    private int numberNewspaper = 0;
    List<Observer> observers = new ArrayList<>();

    public Newspaper() {

    }

    public void newNumber() {
        Random random = new Random();
        int number = random.nextInt(10);
        if (number > 5) {
            numberNewspaper += 1;
            notifyObservers();
        } else {
            System.out.println(this.nameNewspaper + " ###Do not have new number###");
        }
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.handleEvent(nameNewspaper, numberNewspaper);
        }
    }
}
