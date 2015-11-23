package ThirdLesson.HomeWork.CoffeShop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Cappuccino extends Product {

    public Cappuccino(CoffeeSort coffeeSort, CupSize cupSize, SugarQuantiti sugarQuantiti, Milk milk, Additives additives) {
        System.out.println("#####Cappuccino Ingredients#####");
        System.out.println("Cup size: " + cupSize);
        System.out.println("Sort of coffee: " + coffeeSort);
        System.out.println("Quantiti of sugar: " + sugarQuantiti);
        System.out.println("Milk: " + milk);
        System.out.println("Additives: " + additives);
        System.out.println("Cappuccino price: " + "= " + (new BigDecimal(cupSize.getId() + coffeeSort.getId() + sugarQuantiti.getId() + milk.getId() + additives.getId()).setScale(3, RoundingMode.UP).doubleValue()));
    }
}