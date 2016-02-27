package EightLesson.Chapter_2_Task_4;

import java.io.IOException;
import java.io.InputStream;

public class PrintFile {

    public PrintFile() {

    }

    public static void printStreamData(InputStream stream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int i;
        while ((i = stream.read()) != -1) {
            stringBuilder.append((char) i);
        }
        stream.close();
        System.out.println(stringBuilder.toString());
    }
}
