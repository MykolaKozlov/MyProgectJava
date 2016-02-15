package SevenLesson.Chapter_4_Task_3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class InitClass<T> {
    public static void main(String[] args) {
        InitClass initClass = new InitClass();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Mike");
        map.put("age", 25);
        map.put("address", "Kiev");


        TestInvoke testInvoke = null;
        try {
            testInvoke = (TestInvoke) initClass.ininClass(TestInvoke.class, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(testInvoke.getName());
        System.out.println(testInvoke.getAge());
        System.out.println(testInvoke.getAddress());
    }

    public T ininClass(Class<T> c, Map<String, Object> map) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        T obj = c.newInstance();
        Method[] methods = c.getMethods();
        for (Map.Entry<String, Object> e : map.entrySet()) {
            for (Method method : methods) {
                String methodName = method.getName();
                if (methodName.contains("set" + e.getKey().substring(0, 1).toUpperCase() + e.getKey().substring(1, e.getKey().length()))) {
                    method.invoke(obj, e.getValue());
                }
            }
        }
        return obj;
    }
}
