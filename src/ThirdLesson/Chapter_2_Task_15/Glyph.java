package ThirdLesson.Chapter_2_Task_15;

public class Glyph {
    private int[] mass = {1, 2, 3, 4, 5};

    public Glyph() {
        System.out.println("Glyph#constructor");
        numberInMass();
    }

    public void numberInMass() {
        System.out.println(mass[0]);
    }
}
