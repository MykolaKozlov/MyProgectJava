package ThirdLesson.HomeWork.CoffeShop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BlackCoffee extends Product {

    public BlackCoffee(CoffeeSort coffeeSort, CupSize cupSize, SugarQuantiti sugarQuantiti) {
        System.out.println("#####Black Coffee Ingredients#####");
        System.out.println("Cup size: " + cupSize);
        System.out.println("Sort of coffee: " + coffeeSort);
        System.out.println("Quantiti of sugar: " + sugarQuantiti);
        System.out.println("Black Coffee price: " + "= " + (new BigDecimal(cupSize.getId() + coffeeSort.getId() + sugarQuantiti.getId()).setScale(3, RoundingMode.DOWN).doubleValue()));
    }
}
