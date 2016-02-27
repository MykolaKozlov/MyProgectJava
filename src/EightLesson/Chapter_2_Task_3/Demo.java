package EightLesson.Chapter_2_Task_3;

import java.io.File;

public class Demo {
    public static void main(String[] args) {
        FileCopy f = new FileCopy();
        File read = new File("D:\\MyProgectJava\\Catalog\\read.txt");
        f.copyFile(read);

        System.out.println(f.fileWriter(read));
    }
}
