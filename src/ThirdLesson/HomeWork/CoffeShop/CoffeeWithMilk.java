package ThirdLesson.HomeWork.CoffeShop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CoffeeWithMilk extends Product {

    public CoffeeWithMilk(CoffeeSort coffeeSort, CupSize cupSize, SugarQuantiti sugarQuantiti, Milk milk) {
        System.out.println("#####Coffee With Milk Ingredients#####");
        System.out.println("Cup size: " + cupSize);
        System.out.println("Sort of coffee: " + coffeeSort);
        System.out.println("Quantiti of sugar: " + sugarQuantiti);
        System.out.println("Milk: " + milk);
        System.out.println("Coffee With Milk price: " + "= " + (new BigDecimal(cupSize.getId() + coffeeSort.getId() + sugarQuantiti.getId() + milk.getId()).setScale(3, RoundingMode.DOWN).doubleValue()));
    }
}
