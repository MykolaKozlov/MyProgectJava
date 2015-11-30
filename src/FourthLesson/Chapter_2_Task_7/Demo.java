package FourthLesson.Chapter_2_Task_7;

public class Demo {
    public static void main(String[] args) {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        simpleLinkedList.addFirst("1");
        simpleLinkedList.addLast("100");
        simpleLinkedList.addLast("250");
        simpleLinkedList.addFirst("100");
//        simpleLinkedList.addLast("200");

//        simpleLinkedList.addLast("5");

//        simpleLinkedList.addFirst("2");
//        simpleLinkedList.addFirst("3");
        simpleLinkedList.printList();
//        System.out.println(simpleLinkedList.getSise());

    }
}
