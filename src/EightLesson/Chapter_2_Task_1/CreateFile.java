package EightLesson.Chapter_2_Task_1;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) {
        String way = "D:" + File.separator + "MyProgectJava" + File.separator + "Catalog" + File.separator + "file.txt";
        File file = new File(way);
        file.getParentFile().mkdir();
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.exists());
        System.out.println(file.getAbsolutePath());

        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        File f2 = new File(dir);
        File[] rootsf2 = f2.listFiles();
        for (File f : rootsf2) {
            if (f.isDirectory()) {
                System.out.println(f);
            }
        }
    }
}
