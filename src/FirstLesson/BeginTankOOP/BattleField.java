package FirstLesson.BeginTankOOP;

import javax.swing.*;
import java.awt.*;

public class BattleField extends JPanel {
    final boolean COLORDED_MODE = false;
    final int BF_WIDTH = 576;
    final int BF_HEIGHT = 576;

    String[][] battleField = { { " ", "B", "B", " ", "B", "B", " ", "B", " " },
            { "B", " ", "B", " ", " ", "B", " ", " ", "B" },
            {  " ", " ", " ", " ", " ", "B", " ", " ", " " },
            { " ", " ", "B", " ", " ", "B", "B", "B", " "  },
            { "B", " ", " ", " ", " ", "B", " ", " ", " "  },
            {  " ", " ", " ", "B", " ", "B", " ", "B", " " },
            { "B", " ", "B", " ", " ", "B", " ", " ", " " },
            {  " ", "B", " ", " ", " ", "B", " ", " ", " "  },
            { " ", "B", " ", "B", " ", "B", " ", " ", " " } };


    public BattleField() throws Exception {


        JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
        frame.setLocation(750, 150);
        frame.setMinimumSize(new Dimension(BF_WIDTH + 16, BF_HEIGHT + 39));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        ActionField actionField = new ActionField();
        Tank tank = new Tank();
        Bullet bullet = new Bullet();

        super.paintComponent(g);

        int i = 0;
        Color cc;
        for (int v = 0; v < 9; v++) {
            for (int h = 0; h < 9; h++) {
                if (COLORDED_MODE) {
                    if (i % 2 == 0) {
                        cc = new Color(252, 241, 177);
                    } else {
                        cc = new Color(233, 243, 255);
                    }
                } else {
                    cc = new Color(180, 180, 180);
                }
                i++;
                g.setColor(cc);
                g.fillRect(h * 64, v * 64, 64, 64);
            }
        }

        for (int j = 0; j < battleField.length; j++) {
            for (int k = 0; k < battleField.length; k++) {
                if (battleField[j][k].equals("B")) {
                    @SuppressWarnings("static-access")
                    String coordinates = actionField.getQuadrant(j + 1, k + 1);
                    int separator = coordinates.indexOf("_");
                    int y = Integer.parseInt(coordinates
                            .substring(0, separator));
                    int x = Integer.parseInt(coordinates
                            .substring(separator + 1));
                    g.setColor(new Color(0, 0, 255));
                    g.fillRect(x, y, 64, 64);
                }
            }
        }


        g.setColor(new Color(255, 0, 0));
        g.fillRect(tank.tankX, tank.tankY, 64, 64);

        g.setColor(new Color(0, 255, 0));
        if (tank.tankDirection == 1) {
            g.fillRect(tank.tankX + 20, tank.tankY, 24, 34);
        } else if (tank.tankDirection == 2) {
            g.fillRect(tank.tankX + 20, tank.tankY + 30, 24, 34);
        } else if (tank.tankDirection == 3) {
            g.fillRect(tank.tankX, tank.tankY + 20, 34, 24);
        } else {
            g.fillRect(tank.tankX + 30, tank.tankY + 20, 34, 24);
        }

        g.setColor(new Color(255, 255, 0));
        g.fillRect(bullet.bulletX, bullet.bulletY, 14, 14);
    }
}
