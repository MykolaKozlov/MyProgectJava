package ThirdLesson.HomeWork.CoffeShop;

public class Demo {
    public static void main(String[] args) {
        Product product;
        product = new BlackCoffee(CoffeeSort.ARABICA_KONA, CupSize.BIG_SIZE, SugarQuantiti.THREE);
        product = new BlackCoffee(CoffeeSort.ARABICA_TARRUSA, CupSize.MIDDLE_SIZE, SugarQuantiti.FIVE);
    }
}
