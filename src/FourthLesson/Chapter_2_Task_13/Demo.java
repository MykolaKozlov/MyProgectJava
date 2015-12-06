package FourthLesson.Chapter_2_Task_13;

import java.util.Iterator;

public class Demo {
    public static void main(String[] args) {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        simpleLinkedList.addLast("1");
        simpleLinkedList.addLast("2");
        simpleLinkedList.addLast("3");
        simpleLinkedList.addLast("4");
        simpleLinkedList.addLast("5");
        simpleLinkedList.addFirst("-1");
        Iterator iterator = simpleLinkedList.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.remove();
        simpleLinkedList.printList();


    }
}
