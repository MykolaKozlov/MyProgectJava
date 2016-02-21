package SevenLesson.HomeWork.Task_5;

import SevenLesson.Chapter_4_Task_5.Init;
import SevenLesson.Chapter_4_Task_5.PrivateObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class SetPrivateTest {

    private Init init;
    private PrivateObject privateObject;
    private Map<String, Object> map;

    @Before
    public void init() {
        init = new Init();
        privateObject = new PrivateObject();
        map = new HashMap<>();
    }

    @Test(expected = NoSuchFieldException.class)
    public void wrongParameterInMap() throws NoSuchFieldException, IllegalAccessException {
        map.put("name", "Mike");
        map.put("wrongParameter", 25);
        map.put("address", "Kiev");
        init.setPrivates(privateObject, map);
    }

    @Test
    public void allParameterIsRight() throws NoSuchFieldException, IllegalAccessException {
        map.put("name", "Mike");
        map.put("age", 25);
        map.put("address", "Kiev");
        init.setPrivates(privateObject, map);
        assertEquals(privateObject.getName(), "Mike");
        assertEquals(privateObject.getAge(), 25);
        assertEquals(privateObject.getAddress(), "Kiev");
    }
}
