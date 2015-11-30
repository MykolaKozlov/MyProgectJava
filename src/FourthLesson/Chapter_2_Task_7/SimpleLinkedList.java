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
        Node element = new Node();
        element.object = object;
        if (firstElementOfList == null) {
            firstElementOfList = element;
        } else {
            Node first = firstElementOfList;
            Node last = firstElementOfList;
            while (first.refNestElement != null) {
                first = first.refNestElement;
                last = first;
            }
            last.refNestElement = element;
        }
        size++;
    }

    public void addAfter(Object object, Object objectAfter) {

    }

    public int getSise() {
        return size;
    }

    public void printList() {
        Node element = firstElementOfList;
        while (size != 0) {
            if (element == null) {
                System.out.println("null");
            } else {
                System.out.println(element.object + " ");
                element = element.refNestElement;
            }
            size--;
        }
    }
}
