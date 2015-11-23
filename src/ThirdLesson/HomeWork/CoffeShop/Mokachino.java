package ThirdLesson.HomeWork.CoffeShop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Mokachino extends Product {

    public Mokachino(CoffeeSort coffeeSort, CupSize cupSize, SugarQuantiti sugarQuantiti, Milk milk, Additives hotChocolate, Additives cream) {
        System.out.println("#####Mokachino Ingredients#####");
        System.out.println("Cup size: " + cupSize);
        System.out.println("Sort of coffee: " + coffeeSort);
        System.out.println("Quantiti of sugar: " + sugarQuantiti);
        System.out.println("Milk: " + milk);
        System.out.println("Additives: " + hotChocolate);
        System.out.println("Additives: " + cream);
        System.out.println("Mokachino price: " + "= " + (new BigDecimal(cupSize.getId() + coffeeSort.getId() + sugarQuantiti.getId() + milk.getId() + hotChocolate.getId() + cream.getId()).setScale(3, RoundingMode.UP).doubleValue()));
    }
}
