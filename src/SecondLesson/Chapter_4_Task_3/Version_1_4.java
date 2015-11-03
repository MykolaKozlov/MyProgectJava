package SecondLesson.Chapter_4_Task_3;

public class Version_1_4 {
    public static void main(String[] args) {
        Integer a = new Integer(4);
        Integer b = new Integer(10);
        System.out.println(sum(a.intValue(), b.intValue()));

    }

    public static int sum (int a, int b){
        return a + b;
    }
}
