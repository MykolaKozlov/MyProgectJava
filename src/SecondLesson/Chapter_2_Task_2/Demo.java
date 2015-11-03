package SecondLesson.Chapter_2_Task_2;

public class Demo {
    public static void main(String[] args) {
        Instrument i = new Instrument();
        Flute f = new Flute();
        System.out.println(i instanceof Instrument);
        System.out.println(i instanceof Flute);
        System.out.println(f instanceof Instrument);
        System.out.println(f instanceof Flute);
    }
}
