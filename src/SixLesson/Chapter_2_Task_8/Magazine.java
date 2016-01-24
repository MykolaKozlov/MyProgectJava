package SixLesson.Chapter_2_Task_8;

import java.util.*;

public class Magazine extends Observable{

    private String nameMagazine = "Forbes";
    private int numberMagazine = 0;


    public Magazine() {

    }

    public int getNumberMagazine() {
        return numberMagazine;
    }

    public String getNameMagazine() {
        return nameMagazine;
    }

    public void newNumber() {
        Random random = new Random();
        int number = random.nextInt(10);
        if (number > 5) {
            numberMagazine += 1;
            super.setChanged();
        } else {
            System.out.println(this.nameMagazine + " ###Do not have new number###");
        }
    }
}
