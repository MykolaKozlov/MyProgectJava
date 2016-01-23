package SixLesson.Chapter_2_Task_6;

public class Launcher {
    public static void main(String[] args) {
        Newspaper newspaper = new Newspaper();

        Magazine magazine = new Magazine();

        newspaper.addObserver(new Subscriber("Ivan"));
        newspaper.addObserver(new Subscriber("Mykola"));
        newspaper.addObserver(new Subscriber("Igor"));
        newspaper.addObserver(new Subscriber("Vasiliy"));
        newspaper.addObserver(new Subscriber("Evgeniy"));
        newspaper.addObserver(new Subscriber("Oleg"));
        newspaper.addObserver(new Subscriber("Masha"));

        magazine.addObserver(new Subscriber("Ivan"));
        magazine.addObserver(new Subscriber("Mykola"));
        magazine.addObserver(new Subscriber("Igor"));
        magazine.addObserver(new Subscriber("Vasiliy"));
        magazine.addObserver(new Subscriber("Evgeniy"));
        magazine.addObserver(new Subscriber("Oleg"));
        magazine.addObserver(new Subscriber("Masha"));

        for (int i = 0; i < 10; i++) {
            newspaper.newNumber();
            magazine.newNumber();
        }
    }
}
