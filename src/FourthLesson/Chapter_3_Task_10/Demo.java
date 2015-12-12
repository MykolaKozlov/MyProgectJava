package FourthLesson.Chapter_3_Task_10;

import java.util.HashMap;

public class Demo {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        Person person = new Person();
        person.setName("Mykola");
        person.setAge(25);
        person.setSalary(2000);
        Person person1 = new Person();
        person1.setName("Ivan");
        person1.setAge(18);
        person1.setSalary(500);
        Person person2 = new Person();
        person2.setName("Vasiliy");
        person2.setAge(30);
        person2.setSalary(1800);
        Person person3 = new Person();
        person3.setName("Katya");
        person3.setAge(23);
        person3.setSalary(2000);
        Person person4 = new Person();
        person4.setName("Ylia");
        person4.setAge(23);
        person4.setSalary(1500);

        map.put(person.getName(), person);
        map.put(person1.getName(), person1);
        map.put(person2.getName(), person2);
        map.put(person3.getName(), person3);
        map.put(person4.getName(), person4);

        for (Object key: map.keySet()){
            System.out.println(key);
        }

        for (Object value: map.values()){
            System.out.println(value);
        }

        System.out.println(map.get(person.getName()));
        System.out.println(map.get(person1.getName()));
        System.out.println(map.get(person2.getName()));
        System.out.println(map.get(person3.getName()));
        System.out.println(map.get(person4.getName()));





    }
}
