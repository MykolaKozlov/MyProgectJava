package ThirdLesson.HomeWork.CoffeShop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CoffeeAmericano extends Product {

    public CoffeeAmericano(CoffeeSort coffeeSort, CupSize cupSize, SugarQuantiti sugarQuantiti) {
        System.out.println("#####Coffee Americano Ingredients#####");
        System.out.println("Cup size: " + cupSize);
        System.out.println("Sort of coffee: " + coffeeSort);
        System.out.println("Quantiti of sugar: " + sugarQuantiti);
        System.out.println("Coffee Americano price: " + "= " + (new BigDecimal(cupSize.getId() + coffeeSort.getId() + sugarQuantiti.getId()).setScale(3, RoundingMode.DOWN).doubleValue()));
    }
}
