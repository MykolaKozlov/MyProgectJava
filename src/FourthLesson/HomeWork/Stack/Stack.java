package FourthLesson.HomeWork.Stack;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Stack {

    public Stack(){

    }

    LinkedList linkedList = new LinkedList();

    public void printList (){
        for (Object o : linkedList){
            System.out.println(o);
        }
    }

    public void push (Object object){
        linkedList.addLast(object);
    }

    public Object pop (){
        if (linkedList.size() > 0){
            Object o = linkedList.getLast();
            linkedList.removeLast();
            return o;
        } else {
            throw new NoSuchElementException("No element in list!!!");
        }
    }

    public Object peek(){
        if (linkedList.size() > 0){
            return linkedList.getLast();
        } else {
            throw new NoSuchElementException("No element in list!!!");
        }
    }
}
