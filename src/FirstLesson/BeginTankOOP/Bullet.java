package FirstLesson.BeginTankOOP;

import javax.swing.*;

public class Bullet extends JPanel {
    int bulletX = -100;
    int bulletY = -100;
    int bulletSpeed = 5;


    public void deleteBullet() throws Exception {
        ActionField actionField = new ActionField();
        boolean result = actionField.processInterception();
        if (result == true) {
            bulletX = -100;
            bulletY = -100;
            repaintFire();
        }
    }


    public void repaintFire() throws InterruptedException {
        repaint();
        Thread.sleep(bulletSpeed);
    }


}

