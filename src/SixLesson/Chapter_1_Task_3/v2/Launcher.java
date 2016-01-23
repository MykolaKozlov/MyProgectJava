package SixLesson.Chapter_1_Task_3.v2;

import SixLesson.Chapter_1_Task_3.v2.Calc.Calculator;
import SixLesson.Chapter_1_Task_3.v2.Calc.DefaultCalculator;

import java.util.Random;

public class Launcher {

	public static void main(String[] args) {
		Calculator calc = new DefaultCalculator();
		
		Operations o = new Operations();
		o.setCalc(calc);

		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			System.out.println(o.createSummaryReport(r.nextInt(100)));
		}
	}
}
