package FourthLesson.HomeWork.SimpleArrayList;

import java.util.Iterator;

public class Demo {
    public static void main(String[] args) {
        SimpleArrayList simpleArrayList = new SimpleArrayList();
        simpleArrayList.add("1");
        simpleArrayList.add("2");
        simpleArrayList.add("3");

        System.out.println(simpleArrayList.contains("3"));

        simpleArrayList.remove("2");

        simpleArrayList.remove("5");

        System.out.println("size " + simpleArrayList.size());

        Iterator iterator = simpleArrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
