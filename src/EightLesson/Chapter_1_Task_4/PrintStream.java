package EightLesson.Chapter_1_Task_4;

import java.io.ByteArrayInputStream;

public class PrintStream {
    public static void main(String[] args) {
        byte[] bytes = {10, 20, -12, 121, 18, -128, 11, 10, 1};
        ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
        printSteramData(stream);
    }

    public static void printSteramData(ByteArrayInputStream stream) {
        int i;
        while ((i = stream.read()) != -1) {
            System.out.println((byte)i);
        }
    }
}
