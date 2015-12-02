package FourthLesson.Chapter_2_Task_9;

public class Demo {
    public static void main(String[] args) {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        simpleLinkedList.addFirst("-2");

        simpleLinkedList.addFirst("-1");

        simpleLinkedList.addFirst("0");

        simpleLinkedList.addLast("1");

        simpleLinkedList.addLast("2");

        simpleLinkedList.addAfter("2", "3");

        simpleLinkedList.addAfter("10", "3");

        simpleLinkedList.printList();

        System.out.println("List size: " + simpleLinkedList.getSize());
    }
}
