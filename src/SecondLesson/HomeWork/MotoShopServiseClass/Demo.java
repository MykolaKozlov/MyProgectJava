package SecondLesson.HomeWork.MotoShopServiseClass;

public class Demo {
    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.addMotorcycle(MotorcycleBrand.BMW, MotorcycleCategory.SPORTBIKE, MotorcycleColour.BLUE, 12500, 5);

        shop.printShop(shop.motoShop);
    }
}
