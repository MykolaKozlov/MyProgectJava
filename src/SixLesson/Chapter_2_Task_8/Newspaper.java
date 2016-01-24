package SixLesson.Chapter_2_Task_8;

import java.util.Observable;
import java.util.Random;

public class Newspaper extends Observable {

    private String nameNewspaper = "Mursilka";
    private int numberNewspaper = 0;

    public Newspaper() {

    }

    public String getNameNewspaper() {
        return nameNewspaper;
    }

    public int getNumberNewspaper() {
        return numberNewspaper;
    }

    public void newNumber() {
        Random random = new Random();
        int number = random.nextInt(10);
        if (number > 5) {
            numberNewspaper += 1;
            super.setChanged();
        } else {
            System.out.println(this.nameNewspaper + " ###Do not have new number###");
        }
    }
}
