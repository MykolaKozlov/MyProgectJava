package ThirdLesson.Chapter_2_Task_2;

public class Demo {
    public static void main(String[] args) {
        Artist artist = new Artist();
        artist.drawShape(new Circle());
        artist.drawShape(new Rectangle());
        artist.drawShape(new Triangle());
    }
}
