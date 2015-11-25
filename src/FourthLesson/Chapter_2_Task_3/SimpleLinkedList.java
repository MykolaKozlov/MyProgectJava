package FourthLesson.Chapter_2_Task_3;

public class SimpleLinkedList {

    private Node root;
    private int size;

    public SimpleLinkedList() {

    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addFirst(Object object) {

    }

    public void addLast(Object object) {

    }

    public void addAfter(Object object, Object objectAfter) {

    }

    public int getSise() {
        return getSize();
    }

    private class Node {
        Object object;
        Node node;
    }
}
