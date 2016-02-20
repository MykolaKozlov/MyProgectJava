package SevenLesson.HomeWork.Task_1;

public class Launcher {
    public static void main(String[] args) {
        AplicationManeger aplicationManeger = new AplicationManeger();
//        aplicationManeger.chekService(ServiceTestOne.class);
//        aplicationManeger.chekService(ServiceTestTwo.class);

        try {
            aplicationManeger.getService(ServiceTestOne.class).test();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
