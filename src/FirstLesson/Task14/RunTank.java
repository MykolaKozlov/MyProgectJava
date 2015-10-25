package FirstLesson.Task14;
public class RunTank {
    public static void main(String[] args) {
        printTankInfo();
    }
    static void printTankInfo() {
        Tank tank = new Tank();
        tank.colour = "blue";
        tank.crew = 10;
        tank.spead = 60;
        System.out.println(tank.colour);
        System.out.println(tank.crew);
        System.out.println(tank.spead);
    }
}
