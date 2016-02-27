package EightLesson.Chapter_2_Task_4;


import java.io.*;

public class Demo {
    public static void main(String[] args) {
        PrintFile file = new PrintFile();
        File read = new File("D:\\MyProgectJava\\Catalog\\testRead.txt");
        InputStream stream = null;
        try {
            stream = new FileInputStream(read);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            file.printStreamData(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
