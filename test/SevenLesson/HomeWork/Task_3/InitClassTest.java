package SevenLesson.HomeWork.Task_3;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class InitClassTest {

    private InitClass initClass;
    private TestInvoke testInvoke;
    private List list;

    @Before
    public void init() {
        initClass = new InitClass();
        list = new ArrayList<>();
    }

    @Test(expected = NoSuchMethodException.class)
    public void wrongParameterInList() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        list.add("Mike");
        list.add(25);
        list.add("Kiev");
        list.add("no parameter");
        testInvoke = (TestInvoke) initClass.ininClass(TestInvoke.class, list);
    }

    @Test
    public void allParametersIsRight() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        list.add("Mike");
        list.add(25);
        list.add("Kiev");
        testInvoke = (TestInvoke) initClass.ininClass(TestInvoke.class, list);
        assertEquals(testInvoke.getName(), "Mike");
        assertEquals(testInvoke.getAge(), 25);
        assertEquals(testInvoke.getAddress(), "Kiev");
    }

    @Test
    public void twoParametersIsRight() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        list.add("Mike");
        list.add(25);
        testInvoke = (TestInvoke) initClass.ininClass(TestInvoke.class, list);
        assertEquals(testInvoke.getName(), "Mike");
        assertEquals(testInvoke.getAge(), 25);
    }

    @Test
    public void zeroParameter() {
        assertEquals(list.size(), 0);
    }
}
