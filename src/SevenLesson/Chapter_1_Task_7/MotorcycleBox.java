package SevenLesson.Chapter_1_Task_7;

import SevenLesson.Chapter_1_Task_1.Motorcycle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MotorcycleBox<T extends Motorcycle> {

    private List<T> box = new ArrayList<>();

    public MotorcycleBox() {

    }

    public void add(T item) {
        box.add(item);
    }

    public void remove(T item) {
        if (box != null) {
            if (box.contains(item)) {
                box.remove(item);
            } else {
                System.err.println("Element is't find!!!");
            }
        }
    }

    public void sortByColour() {
        box.sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.getMotorcycleColour().compareTo(o2.getMotorcycleColour());
            }
        });
    }

    public void sortByPrice() {
        box.sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return Integer.valueOf(o1.getPrice()).compareTo(Integer.valueOf(o2.getPrice()));
            }
        });
    }

    public void printBox() {
        for (T item : box) {
            System.out.println(item);
        }
    }
}
