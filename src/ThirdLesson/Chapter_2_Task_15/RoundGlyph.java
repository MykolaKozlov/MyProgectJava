package ThirdLesson.Chapter_2_Task_15;

public class RoundGlyph extends Glyph {

    private int[] mass = {1, 2, 3, 4, 5};

    public RoundGlyph() {

    }

    @Override
    public void numberInMass() {
        System.out.println(mass[0]);
    }
}
