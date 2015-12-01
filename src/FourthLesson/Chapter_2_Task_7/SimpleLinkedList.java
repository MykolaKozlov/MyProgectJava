package FourthLesson.Chapter_2_Task_7;

public class SimpleLinkedList {

    private Node firstElementInList;
    private Node lastElementInList;
    private int size;

    public SimpleLinkedList() {
        firstElementInList = null;
        size = 0;
    }

    public class Node {
        public Object object;
        public Node refNexrElementInList;
    }

    public void addFirst(Object object) {
        Node node = new Node();
        node.object = object;
        if (firstElementInList == null) {
            firstElementInList = node;
            lastElementInList = node;
        } else {
            node.refNexrElementInList = firstElementInList;
            firstElementInList = node;
        }
        size++;
    }

    public void addLast(Object object) {
        Node node = new Node();
        node.object = object;
        if (firstElementInList == null) {
            firstElementInList = node;
            lastElementInList = node;
        } else {
            lastElementInList.refNexrElementInList = node;
            lastElementInList = node;
        }
        size++;
    }

    public int getSize() {
        return size;
    }

    public void printList() {
        Node node = firstElementInList;
        while (node != null) {
            System.out.println(node.object + " ");
            node = node.refNexrElementInList;
        }
    }
}
