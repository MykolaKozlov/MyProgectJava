package FourthLesson.Chapter_2_Task_7;

public class SimpleLinkedList {

    private class Node {
        Object object;
        Node refNestElement;
    }

    private Node firstElementOfList;
    private int size;

    public SimpleLinkedList() {
        size = 0;
    }

    public void addFirst(Object object) {
        Node element = new Node();
        element.object = object;
        if (firstElementOfList != null) {
            element.refNestElement = firstElementOfList;
        }
        firstElementOfList = element;
        size++;
    }

    public void addLast(Object object) {


    }

    public void addAfter(Object object, Object objectAfter) {

    }

    public int getSise() {
        return size;
    }

    public void printList() {
        Node element = firstElementOfList;
        while (size != 0) {
            System.out.println(element.object + " ");
            element = element.refNestElement;
            size--;
        }
    }
}
