package SevenLesson.Chapter_4_Task_5;

import java.lang.reflect.Field;
import java.util.Map;

public class Init {

    public Init() {

    }

    public void setPrivates(Object object, Map<String, Object> map) throws NoSuchFieldException, IllegalAccessException {
        for(Map.Entry<String, Object> entry : map.entrySet()) {
            Field field = object.getClass().getDeclaredField(entry.getKey());
            field.setAccessible(true);
            field.set(object, entry.getValue());
        }
    }

}
