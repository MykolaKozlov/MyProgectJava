package SevenLesson.Chapter_4_Task_7;

public class Launcher {
    public static void main(String[] args) {
        AplicationManeger aplicationManeger = new AplicationManeger();
        aplicationManeger.chekService(ServiceTestOne.class);
        aplicationManeger.chekService(ServiceTestTwo.class);
    }
}
