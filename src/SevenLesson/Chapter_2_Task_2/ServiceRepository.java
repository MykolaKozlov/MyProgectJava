package SevenLesson.Chapter_2_Task_2;

import java.util.ArrayList;
import java.util.List;

public class ServiceRepository<T extends Service> {

    private List<T> box = new ArrayList<>();

    public ServiceRepository() {

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
