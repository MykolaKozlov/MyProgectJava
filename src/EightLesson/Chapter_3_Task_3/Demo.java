package EightLesson.Chapter_3_Task_3;

import java.io.File;

public class Demo {
    public static void main(String[] args) {

        File read = new File("D:\\MyProgectJava\\Catalog\\EightLesson\\Chapter_3_Task_3\\Main.java");
        File write = new File("D:\\MyProgectJava\\Catalog\\EightLesson\\Chapter_3_Task_3\\read2.txt");
        ChengeFileCoding coding = new ChengeFileCoding();
        coding.changeCoding(read, write, "CP936", "UTF-16");
    }
}
