package SevenLesson.Chapter_4_Task_4;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class InitClass<T> {
    public static void main(String[] args) {
        InitClass initClass = new InitClass();

        List list = new ArrayList<>();
        list.add("Mike");
        list.add(25);
        list.add("Kiev");

        TestInvoke testInvoke = null;

        try {
            testInvoke = (TestInvoke) initClass.ininClass(TestInvoke.class, list);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(testInvoke.getName());
        System.out.println(testInvoke.getAge());
        System.out.println(testInvoke.getAddress());
    }

    public T ininClass(Class<T> c, List<Object> list) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        T obj;

        Class[] parametrs = new Class[list.size()];
        for (int i = 0; i < list.size(); i++) {
            parametrs[i] = list.get(i).getClass();
        }

        Constructor aConstrct = c.getConstructor(parametrs);
        return obj = (T) aConstrct.newInstance(list.toArray());
    }
}
