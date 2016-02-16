package SevenLesson.Chapter_4_Task_5;

import java.util.HashMap;
import java.util.Map;

public class Demo {

    public static void main(String[] args) {
        Init init = new Init();
        PrivateObject privateObject = new PrivateObject();

        Map map = new HashMap<>();
        map.put("name", "Mike");
        map.put("age", 25);
        map.put("address", "Kiev");

        try {
            init.setPrivates(privateObject, map);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        privateObject.print();
    }
}
