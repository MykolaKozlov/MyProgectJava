package SecondLesson.HomeWork.MotoShopServiseClass;

public class Shop {
    private int numberOfMotorcycle = 10;
    public Motorcycle[][][] motoShop = new Motorcycle[MotorcycleBrand.values().length][MotorcycleCategory.values().length][numberOfMotorcycle];


    public void addMotorcycle(MotorcycleBrand motorcycleBrand, MotorcycleCategory motorcycleCategory, MotorcycleColour motorcycleColour, double price, int quantity) {
        Motorcycle motorcycle = new Motorcycle();
        motorcycle.setMotorcycleBrand(motorcycleBrand);
        motorcycle.setMotorcycleCategory(motorcycleCategory);
        motorcycle.setMotorcycleColour(motorcycleColour);
        motorcycle.setPrice(price);
        motorcycle.setQuantity(quantity);
        addMotorcycleInMotoShop(motorcycle);
    }

    private void addMotorcycleInMotoShop(Motorcycle motorcycle) {
        for (int i = 0; i < motoShop[motorcycle.getMotorcycleBrand().getId()][motorcycle.getMotorcycleCategory().getId()].length; i++) {
            if (motoShop[motorcycle.getMotorcycleBrand().getId()][motorcycle.getMotorcycleCategory().getId()][i] == null) {
                motoShop[motorcycle.getMotorcycleBrand().getId()][motorcycle.getMotorcycleCategory().getId()][i] = motorcycle;
                return;
            }
            if (i == motoShop[motorcycle.getMotorcycleBrand().getId()][motorcycle.getMotorcycleCategory().getId()].length - 1) {
                System.out.println("You need increase size \"motoShop\"");
                break;
            }
        }
    }

    public void printShop(Motorcycle[][][] motoShop) {
        for (int i = 0; i < motoShop.length; i++) {
            for (int j = 0; j < motoShop[i].length; j++) {
                for (int k = 0; k < motoShop[i][j].length; k++) {
                    if (motoShop[i][j][k] == null) {
                        System.out.print("null  ");
                    } else {
                        System.out.print("BIKE  ");
                    }
                }
            }
            System.out.println();
        }
    }

    public void quantityAndPriceOfGoods(MotorcycleBrand motorcycleBrand) {
        for (int i = motorcycleBrand.getId(); i <= motorcycleBrand.getId(); i++) {
            for (int j = 0; j < motoShop[MotorcycleCategory.values().length].length; j++) {
                if (j == MotorcycleCategory.values().length) {
                    break;
                } else {
                    System.out.println("####################" + MotorcycleCategory.values()[j] + "####################");
                }
                int position = 0;
                for (int k = 0; k <= motoShop[i][j].length; k++) {
                    if (motoShop[i][j][k] == null && position == 0) {
                        System.out.println("In this category do not have products");
                        break;
                    } else if (motoShop[i][j][k] == null) {
                        break;
                    } else {
                        System.out.println("BRAND: " + motoShop[i][j][k].getMotorcycleBrand() + "; PRICE: " + motoShop[i][j][k].getPrice() + "$; QUANTITY: " + motoShop[i][j][k].getQuantity() + ".");
                        position = motoShop.length;
                    }
                }
            }
        }

    }


}
