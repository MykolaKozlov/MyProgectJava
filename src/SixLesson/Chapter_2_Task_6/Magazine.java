package SixLesson.Chapter_2_Task_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Magazine implements Observable {

    private String nameMagazine = "Forbes";
    private int numberMagazine = 0;
    List<Observer> observers = new ArrayList<>();

    public Magazine() {

    }

    public void newNumber() {
        Random random = new Random();
        int number = random.nextInt(10);
        if (number > 5) {
            numberMagazine += 1;
            notifyObservers();
        } else {
            System.out.println(this.nameMagazine + " ###Do not have new number###");
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
            o.handleEvent(nameMagazine, numberMagazine);
        }
    }
}
