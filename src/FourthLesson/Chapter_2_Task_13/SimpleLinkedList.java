package FourthLesson.Chapter_2_Task_13;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedList implements Iterable {

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

    public void addAfter(Object object, Object objectPaste) {
        Node paste = new Node();
        paste.object = objectPaste;
        Node cp = firstElementInList;
        if (firstElementInList == null) {
            System.err.println("List is empty");
            return;
        }
        if (size == 1 && cp.object.equals(object)) {
            firstElementInList.refNexrElementInList = lastElementInList.refNexrElementInList;
            lastElementInList.refNexrElementInList = paste;
        }
        if (lastElementInList.object.equals(object)) {
            lastElementInList.refNexrElementInList = paste;
            lastElementInList = paste;
        } else {
            while (cp.refNexrElementInList != null || cp.refNexrElementInList == null) {
                try {
                    if (cp.refNexrElementInList == null) {
                        throw new IllegalStateException();
                    }
                } catch (IllegalStateException e) {
                    System.err.println("Not found parameter " + object + "!!!");
                    return;
                }
                if (cp.object.equals(object) && cp.refNexrElementInList != null) {
                    paste.refNexrElementInList = cp.refNexrElementInList;
                    cp.refNexrElementInList = paste;
                    return;
                }
                cp = cp.refNexrElementInList;
            }
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

    @Override
    public Iterator iterator() {
        return new SSLIterator();
    }

    public class SSLIterator implements Iterator {
        private Node node = firstElementInList;
        private Node prev;
        private int index = 0;

        public SSLIterator() {

        }

        @Override
        public boolean hasNext() {
            if (index < size) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No element in list!!!");
            }
            if (index == 0) {
                index++;
                return node.object;
            } else {
                index++;
                prev = node;
                node = node.refNexrElementInList;
            }
            return node.object;
        }

        @Override
        public void remove() {
            if (node == null) {
                throw new IllegalStateException("No element in list!!!");
            }
            if (node == firstElementInList) {
                firstElementInList = node.refNexrElementInList;
            } else {
                prev.refNexrElementInList = node.refNexrElementInList;
            }
            size--;
        }
    }
}
