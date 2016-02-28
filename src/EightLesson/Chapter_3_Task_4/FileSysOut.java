package EightLesson.Chapter_3_Task_4;

import java.io.*;

public class FileSysOut {
    public static void main(String[] args) {
        File file = new File("D:\\MyProgectJava\\Catalog\\EightLesson\\Chapter_3_Task_4\\Main.txt");

        try {
            System.setOut(new PrintStream(file));
            System.out.println("Hello");
            System.out.println("World!!!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
