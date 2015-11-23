package ThirdLesson.HomeWork.CoffeShop;

public abstract class Product implements AddIngredients {

    public Product() {

    }

    @Override
    public double addCupSize(CupSize cupSize) {
        return cupSize.getId();
    }

    @Override
    public double addSugar(int sugar) {
        return 0;
    }

    @Override
    public double addCoffe(CoffeeSort coffeeSort) {
        return 0;
    }

    @Override
    public double addTea(TeaSort teaSort) {
        return 0;
    }

    @Override
    public double addMilk(double milk) {
        return 0;
    }

    @Override
    public double addNewProduck(String productName, double productPrice, int quantity) {
        return 0;
    }
}
