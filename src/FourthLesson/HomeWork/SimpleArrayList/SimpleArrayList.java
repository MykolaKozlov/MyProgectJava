package FourthLesson.HomeWork.SimpleArrayList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayList implements SimpleList {

    private int massLength = 0;
    private Object elementData[] = new Object[massLength];
    private int size = 0;
    protected int elementPosition = 0;

    public SimpleArrayList() {
        super();
    }

    public void printList() {
        for (int i = 0; i < elementData.length; i++) {
            System.out.println(elementData[i]);
        }
    }

    @Override
    public void add(Object object) {
        if (object != null) {
            Object newMass[] = new Object[size + 1];
            for (int i = 0; i < size; i++) {
                newMass[i] = elementData[i];
            }
            size++;
            elementData = newMass;
            elementData[size - 1] = object;
        }
    }

    @Override
    public boolean contains(Object object) {
        if (object != null) {
            for (int i = 0; i < elementData.length; i++) {
                if (elementData[i].equals(object)) {
                    elementPosition = i;
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public void remove(Object object) {
        if (object != null) {
            if (!contains(object)) {
                System.out.println(object + " is not found!!!");
            } else {
                Object newMass[] = new Object[elementData.length - 1];
                if (elementPosition == 0) {
                    System.arraycopy(elementData, 1, newMass, 0, elementData.length);
                } else {
                    System.arraycopy(elementData, 0, newMass, 0, elementPosition);
                    System.arraycopy(elementData, elementPosition + 1, newMass, elementPosition, elementData.length - elementPosition - 1);
                }
                size--;
                elementData = newMass;
            }
        }
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return new SSLIterator();
    }

    public class SSLIterator implements Iterator {
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
            index++;
            return elementData[index - 1];
        }
    }
}
