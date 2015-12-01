package FourthLesson.Chapter_2_Task_7;

public class Demo {
    public static void main(String[] args) {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        simpleLinkedList.addFirst("-120");
        simpleLinkedList.addLast("1");
        simpleLinkedList.addLast("5");
        simpleLinkedList.addLast("10");
        simpleLinkedList.addLast("10");
        simpleLinkedList.addLast("20");
        simpleLinkedList.addFirst("1");
        simpleLinkedList.printList();
        System.out.println("List size: " + simpleLinkedList.getSize());
    }
}
