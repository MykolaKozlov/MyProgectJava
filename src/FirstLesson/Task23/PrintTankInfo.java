package FirstLesson.Task23;

public class PrintTankInfo {
    public static void main(String[] args) {
        Tank[] t = new Tank[10];
        t[2] = new Tank("blue");
        t[5] = new Tank("grean", 10, 50);
        t[8] = new Tank("grean", 5, 15);
        printInfo(t);
    }

    static void printInfo(Tank[] tank) {
        for (int i = 0; i < tank.length; i++) {
            if (tank[i] == null) {
                System.out.println("null");
            } else {
                System.out.println("Tank colour = " + tank[i].getColour() + "; " + "Tank crew = " + tank[i].getCrew() + "; " + "Tank speed = " + tank[i].getSpeed() + ";");
            }
        }

    }
}
