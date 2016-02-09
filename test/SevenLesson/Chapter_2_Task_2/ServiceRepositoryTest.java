package SevenLesson.Chapter_2_Task_2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class ServiceRepositoryTest {

    private ServiceRepository serviceRepository;

    @Before
    public void init() {
        serviceRepository = new ServiceRepository();
    }

    @Test
    public void testBoxDefaultValue() {
        assertEquals(serviceRepository.getBox().size(), 0);
    }

    @Test
    public void testAdd() {
        SevenLesson.Chapter_2_Task_2.Test test = new SevenLesson.Chapter_2_Task_2.Test();
        serviceRepository.add(test);
        assertEquals(serviceRepository.getBox().size(), 1);
    }

    @Test
    public void testRemoveTrue() {
        SevenLesson.Chapter_2_Task_2.Test test = new SevenLesson.Chapter_2_Task_2.Test();
        serviceRepository.add(test);
        serviceRepository.remove(test);
        assertFalse(serviceRepository.getBox().contains(test));
    }

    @Test
    public void testRemoveFalse() {
        SevenLesson.Chapter_2_Task_2.Test test = new SevenLesson.Chapter_2_Task_2.Test();
        SevenLesson.Chapter_2_Task_2.Test test1 = new SevenLesson.Chapter_2_Task_2.Test();
        serviceRepository.add(test);
        serviceRepository.remove(test1);
        assertTrue(serviceRepository.getBox().contains(test));
    }
}
