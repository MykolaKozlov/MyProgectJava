package EightLesson.Chapter_2_Task_6;

import java.io.File;

public class Demo {
    public static void main(String[] args) {
        FileCopy f = new FileCopy();
        File read = new File("D:\\MyProgectJava\\Catalog\\Main.java");

        f.copyFile(read);

    }
}
