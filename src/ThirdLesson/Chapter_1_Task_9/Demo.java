package ThirdLesson.Chapter_1_Task_9;

public class Demo {
    public static void main(String[] args) {

        try {
            adult(-15);
        } catch (MyPersonalExeption exeption) {
            exeption.printStackTrace();
        }


        String[] array = new String[5];

        try {
            System.out.println(array[6]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println("Such an element in the array does not exist!!!");
        } finally {
            System.out.println("Exit program!");
        }
    }


    public static void adult(int age) throws MyPersonalExeption {
        if (age < 0) {
            throw new MyPersonalExeption();
        } else if (age < 18) {
            System.out.println("You are child");
        } else if (age >= 18) {
            System.out.println("You are adult");
        }
    }
}
