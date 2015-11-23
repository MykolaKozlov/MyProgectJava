package ThirdLesson.HomeWork.CoffeShop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class GreenTea extends Product {

    public GreenTea(TeaSort teaSort, CupSize cupSize, SugarQuantiti sugarQuantiti) {
        System.out.println("#####Green Tea Ingredients#####");
        System.out.println("Cup size: " + cupSize);
        System.out.println("Sort of tea: " + teaSort);
        System.out.println("Quantiti of sugar: " + sugarQuantiti);
        System.out.println("Green Tea price: " + "= " + (new BigDecimal(cupSize.getId() + teaSort.getId() + sugarQuantiti.getId()).setScale(3, RoundingMode.UP).doubleValue()));
    }
}
