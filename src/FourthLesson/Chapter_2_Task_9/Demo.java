package FourthLesson.Chapter_2_Task_9;

public class Demo {
    public static void main(String[] args) {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        simpleLinkedList.addFirst("-120");
        simpleLinkedList.addLast("1");
        simpleLinkedList.addLast("5");
        simpleLinkedList.addLast("10");
        simpleLinkedList.addAfter("15", "100");
        simpleLinkedList.addLast("10");
        simpleLinkedList.printList();
        System.out.println("List size: " + simpleLinkedList.getSize());
    }
}
