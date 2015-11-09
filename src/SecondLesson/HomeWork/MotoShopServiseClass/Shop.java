package SecondLesson.HomeWork.MotoShopServiseClass;

public class Shop {
    private int numberOfMonth = 12;
    private int numberOfDayInMonth = 31;
    private int numberOfGoods = 100;
    public Motorcycle[][][] motoShop = new Motorcycle[MotorcycleBrand.values().length][MotorcycleCategory.values().length][numberOfGoods];
    public Purchase[][][] purchaseArchive = new Purchase[numberOfMonth + 1][numberOfDayInMonth + 1][numberOfGoods];

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
                motorcycle.setProductNumber(motorcycle.getMotorcycleBrand().getId() + "a" + motorcycle.getMotorcycleCategory().getId() + "b" + i + "c");
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
                    System.out.println("#################### CATEGORY: " + MotorcycleCategory.values()[j] + " ####################");
                }
                int position = 0;
                for (int k = 0; k < motoShop[i][j].length; k++) {
                    if (motoShop[i][j][k] == null && position == 0) {
                        System.out.println("In this category do not have products");
                        break;
                    } else if (motoShop[i][j][k] == null) {
                        break;
                    } else {
                        System.out.println("BRAND: " + motoShop[i][j][k].getMotorcycleBrand() + "; PRICE: " + motoShop[i][j][k].getPrice() + "$; QUANTITY: " + motoShop[i][j][k].getQuantity() + "; PRODUCT NUMBER: " + motoShop[i][j][k].getProductNumber() + ".");
                        position = motoShop.length;
                    }
                }
            }
        }
    }

    public void showCatalogOfGoods() {
        for (int i = 0; i < motoShop.length; i++) {
            if (i == MotorcycleBrand.values().length) {
                break;
            } else {
                System.out.println("#################### BRAND: " + MotorcycleBrand.values()[i] + " ####################");
            }
            for (int j = 0; j < motoShop[MotorcycleCategory.values().length].length; j++) {
                if (j == MotorcycleCategory.values().length) {
                    break;
                } else {
                    System.out.println("CATEGORY: " + MotorcycleCategory.values()[j]);
                }
                int position = 0;
                for (int k = 0; k < motoShop[i][j].length; k++) {
                    if (motoShop[i][j][k] == null && position == 0) {
                        System.out.println("In this category do not have products");
                        break;
                    } else if (motoShop[i][j][k] == null) {
                        break;
                    } else {
                        System.out.println("BRAND: " + motoShop[i][j][k].getMotorcycleBrand() + "; PRICE: " + motoShop[i][j][k].getPrice() + "$; QUANTITY: " + motoShop[i][j][k].getQuantity() + "; PRODUCT NUMBER: " + motoShop[i][j][k].getProductNumber() + ".");
                        position = motoShop.length;
                    }
                }
            }
        }
    }

    private Motorcycle findGoodsByProductNumber(String productNumber) {
        return motoShop[Integer.parseInt(productNumber.substring(0, productNumber.indexOf("a")))][Integer.parseInt(productNumber.substring(productNumber.indexOf("a") + 1, productNumber.indexOf("b")))][Integer.parseInt(productNumber.substring(productNumber.indexOf("b") + 1, productNumber.indexOf("c")))];
    }

    private void findDateAdress(String date, Purchase purchase){
        for (int i = 0; i <= purchaseArchive[Integer.parseInt(date.substring(0, date.indexOf(";")))][Integer.parseInt(date.substring(date.indexOf(";") + 1, date.length()))].length; i++){
            if (purchaseArchive[Integer.parseInt(date.substring(0, date.indexOf(";")))][Integer.parseInt(date.substring(date.indexOf(";") + 1, date.length()))][i] == null){
                purchaseArchive[Integer.parseInt(date.substring(0, date.indexOf(";")))][Integer.parseInt(date.substring(date.indexOf(";") + 1, date.length()))][i] = purchase;
                return;
            }
            if (i == purchaseArchive[Integer.parseInt(date.substring(0, date.indexOf(";")))][Integer.parseInt(date.substring(date.indexOf(";") + 1, date.length()))].length - 1){
                System.out.println("You need increase size \"purchaseArchive\"");
                break;
            }
        }
    }

    public void byMotorcycle(String productNumber, int quantity, String fullName, String telephoneNumber, String adress, String date) {
        Purchase purchase = new Purchase();
        purchase.setPrice(findGoodsByProductNumber(productNumber).getPrice());
        purchase.setQuantity(quantity);
        purchase.setMotorcycle(findGoodsByProductNumber(productNumber));
        purchase.setDate(date);
        purchase.setAdress(adress);
        purchase.setFullName(fullName);
        purchase.setTelephoneNumber(telephoneNumber);
        findDateAdress(date, purchase);
        findGoodsByProductNumber(productNumber).setQuantity(findGoodsByProductNumber(productNumber).getQuantity() - quantity);
    }
}
