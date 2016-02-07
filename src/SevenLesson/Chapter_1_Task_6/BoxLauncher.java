package SevenLesson.Chapter_1_Task_6;

import SevenLesson.Chapter_1_Task_1.BMW;
import SevenLesson.Chapter_1_Task_1.HONDA;
import SevenLesson.Chapter_1_Task_1.Motorcycle;

public class BoxLauncher {
    public static void main(String[] args) {
        MotorcycleBox<Motorcycle> motorcycleBox = new MotorcycleBox();
        motorcycleBox.add(new BMW());
        motorcycleBox.add(new HONDA());
    }
}
