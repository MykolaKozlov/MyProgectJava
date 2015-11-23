package ThirdLesson.HomeWork.CoffeShop;

public interface AddIngredients {

    public double addCupSize(CupSize cupSize);

    public double addSugar(int sugar);

    public double addCoffe(CoffeeSort coffeeSort);

    public double addTea(TeaSort teaSort);

    public double addMilk(double milk);

    public double addNewProduck(String productName, double productPrice, int quantity);

}
