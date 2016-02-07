package SevenLesson.Chapter_1_Task_3;

public class BoxLauncher {
    public static void main(String[] args) {
        Box<Integer> box = new Box();
        box.add(1);
        box.add(2);
        box.add(3);
        box.add(4);
        box.add(5);
        box.remove(1);
        box.remove(6);

        box.printBox();
    }
}
