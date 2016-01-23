package SixLesson.Chapter_1_Task_3.v1.Calc;

import SixLesson.Chapter_1_Task_3.Arifmetika;

public class Calculator {

    Arifmetika arifmetika;

    public Calculator() {
        arifmetika = new Arifmetika();
    }

    public int summa(int a, int b) {
        int [] numbers = {a, b};
        return arifmetika.summa(numbers);
    }

    public int multiply(int a, int b) {
        return arifmetika.multiply(a, b);
    }
}
