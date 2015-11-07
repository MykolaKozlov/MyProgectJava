package SecondLesson.HomeWork;

public class Client {
    private String name;
    private int age;
    private Sex sex;
    private String telephoneNumber;
    private String adress;


    public Client() {

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
