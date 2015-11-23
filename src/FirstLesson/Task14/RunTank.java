package FirstLesson.Task14;
public class RunTank {
    public static void main(String[] args) {
        printTankInfo();
    }
    public static void printTankInfo() {
        Tank tank = new Tank();
        tank.colour = "blue";
        tank.crew = 10;
        tank.speed = 60;
        System.out.println("AbstractTank colour = " + tank.colour + ";" + " AbstractTank crew = " + tank.crew + ";" + " AbstractTank speed = " + tank.speed+ ";");
    }
}
