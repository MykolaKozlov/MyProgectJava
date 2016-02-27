package EightLesson.Chapter_2_Task_6;

import java.io.*;

public class FileCopy {

    public FileCopy() {

    }

    public void copyFile(File read) {
        String nameNewFile = read.getName().substring(0, read.getName().indexOf(".")) + "Copy" + read.getName().substring(read.getName().indexOf("."), read.getName().length());
        String way = "D:" + File.separator + "MyProgectJava" + File.separator + "Catalog" + File.separator + nameNewFile;
        File write = new File(way);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(read), 256);
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(write), 256)) {
            String b;
            while ((b = bufferedReader.readLine()) != null) {
                bufferedWriter.newLine();
                bufferedWriter.write(b);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
