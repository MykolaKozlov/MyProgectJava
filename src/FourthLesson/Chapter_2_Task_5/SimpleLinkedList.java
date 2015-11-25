package FourthLesson.Chapter_2_Task_5;

public class SimpleLinkedList {

    private Node root;
    private int size;

    public SimpleLinkedList() {
        size = 0;
    }

    public void addFirst(Object object) {
        Node node = new Node(object, root);
        root = node;
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

        public Node() {

        }

        public Node(Object object, Node root) {
            this.object = object;
        }
    }
}
