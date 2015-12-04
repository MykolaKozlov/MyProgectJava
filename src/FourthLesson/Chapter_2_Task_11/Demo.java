package FourthLesson.Chapter_2_Task_11;

import java.util.Iterator;

public class Demo {
    public static void main(String[] args) {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        simpleLinkedList.addLast("1");
        simpleLinkedList.addLast("2");
        simpleLinkedList.addLast("3");
        simpleLinkedList.addLast("4");
        simpleLinkedList.addLast("5");
        Iterator iterator = simpleLinkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
