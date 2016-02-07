package SevenLesson.Chapter_1_Task_7;

import SevenLesson.Chapter_1_Task_1.BMW;
import SevenLesson.Chapter_1_Task_1.Motorcycle;
import SevenLesson.Chapter_1_Task_1.MotorcycleColour;

public class BoxLauncher {
    public static void main(String[] args) {
        MotorcycleBox<Motorcycle> motorcycleBox = new MotorcycleBox();
        BMW bmw = new BMW();
        bmw.setBrand("BMW");
        bmw.setModel("S 1000 RR");
        bmw.setMotorcycleColour(MotorcycleColour.BLACK);
        bmw.setPrice(10000);

        BMW bmw2 = new BMW();
        bmw2.setBrand("BMW");
        bmw2.setModel("K 1600 GT");
        bmw2.setMotorcycleColour(MotorcycleColour.WHITE);
        bmw2.setPrice(5000);




        motorcycleBox.add(bmw);
        motorcycleBox.add(bmw2);

//        motorcycleBox.sortByPrice();

        motorcycleBox.printBox();


    }
}
