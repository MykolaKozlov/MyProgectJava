package FourthLesson.Chapter_2_Task_11;

public class Demo {
    public static void main(String[] args) {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        simpleLinkedList.addFirst("-1");
        simpleLinkedList.addLast("1");
        simpleLinkedList.addLast("2");
        simpleLinkedList.addAfter("2", "3");
        simpleLinkedList.addLast("3");
        simpleLinkedList.addLast("4");
        simpleLinkedList.addAfter("4", "3");
        simpleLinkedList.addLast("5");
        simpleLinkedList.addFirst("0");
        simpleLinkedList.addFirst("6");
        simpleLinkedList.addAfter("-1", "-1");
//        Iterator iterator = simpleLinkedList.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        for (Object s: simpleLinkedList){
            System.out.println(s);
        }
    }
}
