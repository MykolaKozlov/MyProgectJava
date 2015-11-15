package ThirdLesson.Chapter_1_Task_9;

public class MyPersonalExeption extends Exception{
    @Override
    public void printStackTrace() {
        System.out.println("Age can not be negative!!!");
    }
}
