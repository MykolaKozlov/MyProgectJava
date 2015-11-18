package ThirdLesson.Chapter_3_Task_2;

import java.awt.*;

public abstract class AbstractShape {
    public AbstractShape() {
        System.out.println("AbstractShape");
    }

    public abstract void draw(Graphics graphics);
}
