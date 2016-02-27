package EightLesson.Chapter_2_Task_3;

import java.io.*;

public class FileCopy {

    public FileCopy() {

    }

    public void copyFile(File read) {
        String nameNewFile = read.getName().substring(0, read.getName().indexOf(".")) + "Copy" + read.getName().substring(read.getName().indexOf("."), read.getName().length());
        String way = "D:" + File.separator + "MyProgectJava" + File.separator + "Catalog" + File.separator + nameNewFile;
        File write = new File(way);

        try (FileReader reader = new FileReader(read); FileWriter writer = new FileWriter(write)) {
            int b;
            while ((b = reader.read()) != -1) {
                writer.write(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String fileWriter(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        int b;
        try (FileInputStream inputStream = new FileInputStream(file)) {
            while ((b = inputStream.read()) != -1) {
                stringBuilder.append((char) b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
