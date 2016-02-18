package SevenLesson.Chapter_4_Task_7;

public class AplicationManeger {

    public void chekService(Class<?> c) {
        if (c.isAnnotationPresent(Service.class)) {
            System.out.println(c.getSimpleName() + " have Service annotation");
        } else {
            System.out.println(c.getSimpleName() + " do not have Service annotation");
        }
    }
}
