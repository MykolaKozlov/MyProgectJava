package SixLesson.Chapter_1_Task_3.v2.Calc;

import SixLesson.Chapter_1_Task_3.Arifmetika;

public class ArifmeticaCalculator implements Calculator {


    @Override
    public int summa(int a, int b) {
        return Arifmetika.summa(new int[]{a, b});
    }

    @Override
    public int multiply(int a, int b) {
        return Arifmetika.multiply(a, b);
    }
}
