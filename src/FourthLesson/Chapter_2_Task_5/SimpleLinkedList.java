package FourthLesson.Chapter_2_Task_5;

public class SimpleLinkedList {

    private Node root;
    private int size;

    public SimpleLinkedList() {
        size = 0;
    }

    public void addFirst(Object object) {
        Node node = new Node();
        node.object = object;
        if (root != null) {
            node.node = root;
        }
        root = node;
        size++;
    }

    public void addLast(Object object) {

    }

    public void addAfter(Object object, Object objectAfter) {

    }

    public int getSise() {
        return size;
    }

    private class Node {
        Object object;
        Node node;
    }
}
