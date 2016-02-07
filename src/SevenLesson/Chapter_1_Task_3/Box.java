package SevenLesson.Chapter_1_Task_3;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {

    private List<T> box = new ArrayList<>();

    public Box() {

    }

    public void add(T item) {
        box.add(item);
    }

    public void remove(T item) {
        if (box != null) {
            if (box.contains(item)) {
                box.remove(item);
            }else {
                System.err.println("Element is't find!!!");
            }
        }
    }

    public void printBox() {
        for (T item : box) {
            System.out.println(item);
        }
    }
}
