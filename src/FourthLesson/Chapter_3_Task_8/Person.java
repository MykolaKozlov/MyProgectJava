package FourthLesson.Chapter_3_Task_8;

public class Person {
    private String name;
    private int age;
    private long salary;
    private Address address;

    public Person() {

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

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Person person = (Person) object;

        if (age != person.age) return false;
        if (salary != person.salary) return false;
        if (!name.equals(person.name)) return false;
        return address.equals(person.address);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + (int) (salary ^ (salary >>> 32));
        if (address != null) {
            result = 31 * result + address.hashCode();
        }
        return result;
    }
}
