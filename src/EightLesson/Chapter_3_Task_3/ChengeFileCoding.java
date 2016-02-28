package EightLesson.Chapter_3_Task_3;

import java.io.*;

public class ChengeFileCoding {

    public ChengeFileCoding() {
    }

    public void changeCoding(File file, File file2, String currentEncoding, String neededEncoding) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), currentEncoding));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2), neededEncoding))) {

            int c;
            while ((c = reader.read()) != -1) {
                writer.write((char)c);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
