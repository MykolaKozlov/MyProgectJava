package SecondLesson.Chapter_4_Task_3;

public class Version_1_8 {
    public static void main(String[] args) {
        Integer a = 10;
        Integer b = new Integer(5);
        int i = new Integer(15);

        System.out.println(sum(a, b) + i);

    }
   public static int sum (int a, int b){
        return a + b;
    }
}
