package FirstLesson.HomeworkFirstLesson.Enum;
public class CarLouncher {
    public static void main(String[] args) {
        Car car = new Car();
        car.carInformation(car);
        car.setCarColor(Color.DARK_GREEN);
        car.carInformation(car);
        car.setCarDoor(5);
        car.carInformation(car);
        car.setCarModel("Porsche");
        car.setCarDoor(2);
        car.setCarColor(Color.BLUE);
        car.setCarNumber("BI 1010 AA");
        car.carInformation(car);
    }

}
