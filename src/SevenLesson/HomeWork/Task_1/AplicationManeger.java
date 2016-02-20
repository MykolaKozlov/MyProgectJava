package SevenLesson.HomeWork.Task_1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AplicationManeger {

    public <T> void chekService(Class<T> c) {
        if (c.isAnnotationPresent(Service.class)) {
            Method[] methods = c.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(initService.class)) {
                    try {
                        method.invoke(c.newInstance());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }

        } else {
            System.out.println(c.getSimpleName() + " do not have Service annotation!!!");
        }
    }

    public <T> T getService(Class<T> c) throws IllegalAccessException, InstantiationException {
        return c.newInstance();
    }
}
