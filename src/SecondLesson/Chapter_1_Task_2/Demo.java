package SecondLesson.Chapter_1_Task_2;

public class Demo {
	public static void main(String[] args) {
		BT7 bt7 = new BT7();
		bt7.setColour(Colour.DARK_GREEN);
		bt7.setSpeed(76);
		bt7.setCrew(8);

		T34 t34 = new T34();
		t34.setColour(Colour.BLACK);
		t34.setSpeed(50);
		t34.setCrew(6);

		Tiger tiger = new Tiger();
		tiger.setColour(Colour.GREY);
		tiger.setSpeed(36);
		tiger.setCrew(4);

		System.out.println("BT7 colour = " + bt7.getColour() + "; " + "BT7 crew = " + bt7.getCrew() + "; " + "BT7 speed = " + bt7.getSpeed() + ";");

		System.out.println("T34 colour = " + t34.getColour() + "; " + "T34 crew = " + t34.getCrew() + "; " + "T34 speed = " + t34.getSpeed() + ";");

		System.out.println("Tiger colour = " + tiger.getColour() + "; " + "Tiger crew = " + tiger.getCrew() + "; " + "Tiger speed = " + tiger.getSpeed() + ";");
	}
}
