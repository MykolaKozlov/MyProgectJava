package EightLesson.Chapter_3_Task_5;

public class Demo {
    public static void main(String[] args) {
        Arhivator arhivator = new Arhivator();
        arhivator.createZip("C:\\Users\\Николай\\Desktop\\Новая папка");
        arhivator.unZip("C:\\Users\\Николай\\Desktop\\Новая папка.zip");
    }
}
