package ThirdLesson.Chapter_2_Task_2;

public class Artist {
    public Artist() {
        System.out.println("Artist");
    }

    public void drawShape(Shape shape) {
        System.out.println("Drawing " + shape.draw());
    }
}
