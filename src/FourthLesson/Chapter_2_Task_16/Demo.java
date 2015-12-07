package FourthLesson.Chapter_2_Task_16;

import java.util.ArrayList;
import java.util.Collections;

public class Demo {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("A");
        list.add("b");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("G");
        list.add("H");
        list.add("B");
        list.add("A");
        Collections.sort(list, new Comparator());
        System.out.println(list);
    }
}
