package ThirdLesson.HomeWork.CoffeShop;

public class Demo {
    public static void main(String[] args) {
        Product product;
        product = new BlackCoffee(CoffeeSort.ARABICA_KONA, CupSize.BIG_SIZE, SugarQuantiti.THREE);
        product = new BlackCoffee(CoffeeSort.ARABICA_TARRUSA, CupSize.MIDDLE_SIZE, SugarQuantiti.FIVE);
        product = new CoffeeWithMilk(CoffeeSort.ARABICA_MOCCA, CupSize.BIG_SIZE, SugarQuantiti.TWO, Milk.NONE);
        product = new CoffeeAmericano(CoffeeSort.ARABICA_MOCCA, CupSize.BIG_SIZE, SugarQuantiti.NONE);
        product = new Cappuccino(CoffeeSort.ARABICA_TARRUSA, CupSize.BIG_SIZE, SugarQuantiti.TWO, Milk.MILK, Additives.CHOCOLATE);
        product = new Mokachino(CoffeeSort.ARABICA_TARRUSA, CupSize.BIG_SIZE, SugarQuantiti.TWO, Milk.MILK, Additives.HOT_CHOCOLATE, Additives.CREAM);
        product = new BlackTea(TeaSort.BLACK_TEA, CupSize.BIG_SIZE, SugarQuantiti.THREE);
        product = new GreenTea(TeaSort.GREEN_TEA, CupSize.BIG_SIZE, SugarQuantiti.ONE);
    }
}
