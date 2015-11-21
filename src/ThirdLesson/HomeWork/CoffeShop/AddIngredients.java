package ThirdLesson.HomeWork.CoffeShop;

public interface AddIngredients {

    public double addWaterSize(AddWaterSize addWaterSize);

    public double addSugar(int sugar);

    public double addCoffe(CoffeSort coffeSort);

    public double addTea(TeaSort teaSort);

    public double addMilk(double milk);

    public double addNewProduck (String productName, double productPrice, int quantity);

}
