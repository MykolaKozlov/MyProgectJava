package SevenLesson.HomeWork.Task_5_Generics;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InvalidPropertiesFormatException;
import java.util.Locale;

public class Shop {

    private int discountSum = 100000;

    private int transactions = 0;
    private int money = 0;
    private int purchases = 0;
    private int numberOfMonth = 13;
    private int numberOfDayInMonth = 32;
    private int numberOfGoods = 100;
    public Motorcycle[][][] motoShop = new Motorcycle[MotorcycleBrand.values().length][MotorcycleCategory.values().length][numberOfGoods];
    public Purchase[][][] purchaseArchive = new Purchase[numberOfMonth][numberOfDayInMonth][numberOfGoods];

    private Date dateOfBy;
    private SimpleDateFormat month;
    private SimpleDateFormat day;

    public Shop() {
        dateOfBy = new Date();
        month = new SimpleDateFormat("M", Locale.ENGLISH);
        day = new SimpleDateFormat("dd", Locale.ENGLISH);
    }

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
            if (i == MotorcycleBrand.values().length) {
                break;
            } else {
                System.out.println("-------------------- BRAND: " + MotorcycleBrand.values()[i] + " --------------------");
            }
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
                System.out.println("-------------------- BRAND: " + MotorcycleBrand.values()[i] + " --------------------");
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

    private void findDateAdress(String month, String day, Purchase purchase) {
        for (int i = 0; i <= purchaseArchive[Integer.parseInt(month)][Integer.parseInt(day)].length; i++) {
            if (purchaseArchive[Integer.parseInt(month)][Integer.parseInt(day)][i] == null) {
                purchaseArchive[Integer.parseInt(month)][Integer.parseInt(day)][i] = purchase;
                return;
            }
            if (i == purchaseArchive[Integer.parseInt(month)][Integer.parseInt(day)].length - 1) {
                System.out.println("You need increase size \"purchaseArchive\"");
                break;
            }
        }
    }

    public void byMotorcycle(String productNumber, int quantity, String fullName) {
        if (findGoodsByProductNumber(productNumber).getQuantity() >= quantity) {
            Purchase purchase = new Purchase();
            purchase.setPrice(findGoodsByProductNumber(productNumber).getPrice());
            purchase.setQuantity(quantity);
            purchase.setMotorcycle(findGoodsByProductNumber(productNumber));

            purchase.setFullName(fullName);
            findDateAdress(month.format(dateOfBy), day.format(dateOfBy), purchase);
            findGoodsByProductNumber(productNumber).setQuantity(findGoodsByProductNumber(productNumber).getQuantity() - quantity);
        } else {
            try {
                throw new InvalidPropertiesFormatException("Enter fewer");
            } catch (InvalidPropertiesFormatException e) {
                e.printStackTrace();
            }
        }

    }

    private Purchase findDayOnPurchaseArchive(int counter) {
        return purchaseArchive[Integer.parseInt(month.format(dateOfBy))][Integer.parseInt(day.format(dateOfBy))][counter];
    }

    public String[] transactionsDuringTheDay() {
        String[] str = new String[7];
        for (int i = 0; i < purchaseArchive[Integer.parseInt(month.format(dateOfBy))][Integer.parseInt(day.format(dateOfBy))].length; i++) {
            if (findDayOnPurchaseArchive(i) != null) {
                money = (int) (findDayOnPurchaseArchive(i).getPrice() * findDayOnPurchaseArchive(i).getQuantity());
                transactions = 1;
                str[0] = Integer.toString(i + 1);
                str[1] = findDayOnPurchaseArchive(i).getFullName();
                str[2] = findDayOnPurchaseArchive(i).getMotorcycle().getMotorcycleBrand().toString();
                str[3] = Integer.toString((int) findDayOnPurchaseArchive(i).getPrice());
                str[4] = Integer.toString(findDayOnPurchaseArchive(i).getQuantity());
                str[5] = discount(money)[0];
                str[6] = discount(money)[1];

                transactions += i;
                purchases += findDayOnPurchaseArchive(i).getQuantity();
            }
        }
        return str;
    }

    public String[] discount(int money) {
        String[] sum = new String[2];
        if (money > discountSum) {
            sum[0] = "10%";
            sum[1] = Double.toString(money * 0.9);
        } else {
            sum[0] = "5%";
            sum[1] = Double.toString(money * 0.95);
        }
        return sum;
    }

    public void transactionsDuringPeriod(String firstdate, String lastDate) {
        int monthFirstdate = Integer.parseInt(firstdate.substring(0, firstdate.indexOf(";")));
        int dayFirstdate = Integer.parseInt(firstdate.substring(3, firstdate.length()));
        int monthLastDate = Integer.parseInt(lastDate.substring(0, lastDate.indexOf(";")));
        int dayLastDate = Integer.parseInt(lastDate.substring(3, lastDate.length()));
        if (monthFirstdate == monthLastDate) {
            for (int i = monthFirstdate; i <= monthLastDate; i++) {
                for (int j = dayFirstdate; j <= dayLastDate; j++) {
                    for (int k = 0; k < purchaseArchive[i][j].length; k++) {
                        if (purchaseArchive[i][j][k] == null) {
                            System.out.println("Month:" + "(" + monthFirstdate + ")" + " Day:" + "(" + j + ")" + ": " + k + "-transactions");
                            break;
                        }
                    }
                }
            }
        }
        if (monthFirstdate != monthLastDate) {
            for (int i = monthFirstdate, g = 0; i <= monthLastDate; i++, g++) {
                if (i != monthLastDate && g == 0) {
                    for (int j = dayFirstdate; j < numberOfDayInMonth; j++) {
                        for (int k = 0; k < purchaseArchive[i][j].length; k++) {
                            if (purchaseArchive[i][j][k] == null) {
                                System.out.println("Month:" + "(" + monthFirstdate + ")" + " Day:" + "(" + j + ")" + ": " + k + "-transactions");
                                break;
                            }
                        }
                    }
                }
                if (i != monthLastDate && g != 0) {
                    for (int j = 1; j < numberOfDayInMonth; j++) {
                        for (int k = 0; k < purchaseArchive[i][j].length; k++) {
                            if (purchaseArchive[i][j][k] == null) {
                                System.out.println("Month:" + "(" + i + ")" + " Day:" + "(" + j + ")" + ": " + k + "-transactions");
                                break;
                            }
                        }
                    }
                }
                if (i == monthLastDate) {
                    for (int j = 1; j <= dayLastDate; j++) {
                        for (int k = 0; k < purchaseArchive[i][j].length; k++) {
                            if (purchaseArchive[i][j][k] == null) {
                                System.out.println("Month:" + "(" + monthLastDate + ")" + " Day:" + "(" + j + ")" + ": " + k + "-transactions");
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void addGoods() {
        addMotorcycle(MotorcycleBrand.BMW, MotorcycleCategory.SPORTBIKE, MotorcycleColour.BLUE, 12500, 50);
        addMotorcycle(MotorcycleBrand.HONDA, MotorcycleCategory.TURIST, MotorcycleColour.BLACK, 10000, 2);
        addMotorcycle(MotorcycleBrand.HONDA, MotorcycleCategory.MINIBIKE, MotorcycleColour.RED, 5000, 2);
        addMotorcycle(MotorcycleBrand.HONDA, MotorcycleCategory.SPORTBIKE, MotorcycleColour.YELLOW, 20000, 2);
        addMotorcycle(MotorcycleBrand.DUCATI, MotorcycleCategory.TURIST, MotorcycleColour.GREEN, 11500, 2);
        addMotorcycle(MotorcycleBrand.HARLEY_DAVIDSON, MotorcycleCategory.MINIBIKE, MotorcycleColour.ORANGE, 5000, 4);
        addMotorcycle(MotorcycleBrand.KTM, MotorcycleCategory.TURIST, MotorcycleColour.ORANGE, 7500, 5);
        addMotorcycle(MotorcycleBrand.SUZUKI, MotorcycleCategory.SPORTBIKE, MotorcycleColour.GREEN, 20000, 1);
        addMotorcycle(MotorcycleBrand.KAWASAKI, MotorcycleCategory.SPORTBIKE, MotorcycleColour.BLUE, 5000, 2);
        addMotorcycle(MotorcycleBrand.JAVA, MotorcycleCategory.CLASSIC, MotorcycleColour.RED, 1000, 3);
        addMotorcycle(MotorcycleBrand.YAMAHA, MotorcycleCategory.SPORTBIKE, MotorcycleColour.YELLOW, 13600, 4);
    }
}
