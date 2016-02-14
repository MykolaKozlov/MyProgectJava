package SevenLesson.Chapter_4_Task_2;

import SixLesson.Homework.Battlefield.Rock;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassForTest {
    public static void main(String[] args) throws Exception {

        printClassInfo(Rock.class);
        printClassMethod(Rock.class);
        printClassFields(Rock.class);

    }

    public static void printClassInfo(Class<?> c) {
        System.out.println("############" + c.getSimpleName() + "############");
        Class<?> scl = c.getSuperclass();

        System.out.println("Name class: " + c.getName());
        System.out.println("Canonical name class: " + c.getCanonicalName());
        System.out.println("Type nameclass: " + c.getTypeName());

        if (scl != null) {
            printClassInfo(scl);
        }
    }

    public static void printClassMethod(Class<?> c) {
        System.out.println("############" + c.getSimpleName() + "############");
        Class<?> scl = c.getSuperclass();

        Method[] methods = c.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.print("Methods: ");
            System.out.println(methods[i]);
        }
        Constructor[] constructors = c.getDeclaredConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.print("Constructors: ");
            System.out.println(constructors[i]);
        }

        if (scl != null) {
            printClassMethod(scl);
        }
    }

    public static void printClassFields(Class<?> c) {
        System.out.println("############" + c.getSimpleName() + "############");
        Class<?> scl = c.getSuperclass();

        Field[] fields = c.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.print("Fields: ");
            System.out.println(fields[i]);
        }

        if (scl != null) {
            printClassFields(scl);
        }
    }
}
