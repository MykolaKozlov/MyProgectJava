package FirstLesson.HomeworkFirstLesson.Enum;

public class Car {
    private String carModel;
    private String carNumber;
    private Color carColor;
    private int carMaxSpeed;
    private int carDoor;
    private double carWeight;
    private boolean carDrive;

    public Car() {
        carModel = "Subaru";
        carNumber = "BI 0000 AA";
        carColor = Color.DARK_BLUE;
        carMaxSpeed = 220;
        carDoor = 4;
        carWeight = 1505.7;
        carDrive = true;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Color getCarColor() {
        return carColor;
    }

    public void setCarColor(Color carColor) {
        this.carColor = carColor;
    }

    public int getCarMaxSpeed() {
        return carMaxSpeed;
    }

    public void setCarMaxSpeed(int carMaxSpeed) {
        this.carMaxSpeed = carMaxSpeed;
    }

    public int getCarDoor() {
        return carDoor;
    }

    public void setCarDoor(int carDoor) {
        this.carDoor = carDoor;
    }

    public double getCarWaight() {
        return carWeight;
    }

    public void setCarWeight(double carWaight) {
        this.carWeight = carWaight;
    }

    public boolean isCarDrive() {
        return carDrive;
    }

    public void setCarDrive(boolean carDrive) {
        this.carDrive = carDrive;
    }

    public void carIsMoving(boolean carDrive) {
        if (carDrive == true) {
            System.out.println("Car is moving");
        } else {
            System.out.println("Car is stop");
        }
    }

    public void carInformation(Car car) {
        System.out.println("Car model - " + car.carModel + "; " + "Car number - " + car.carNumber + "; "
                + "Car color - " + car.carColor + "; " + "Car maxSpeed - " + car.carMaxSpeed + "; " + "Car door - " + car.carDoor
                + "; " + "Car weight - " + car.carWeight + "; " + "Car is moving " + car.carDrive + ";");
    }
}
