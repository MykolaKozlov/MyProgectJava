package SevenLesson.Chapter_4_Task_5;

public class PrivateObject {
    private String name;
    private int age;
    private String address;

    public PrivateObject() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void print() {
        System.out.println("Name: " + name + " Age: " + age + " Address: " + address);
    }

}
