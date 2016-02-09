package SevenLesson.Chapter_2_Task_2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class ServiceRepositoryTest {

    private ServiceRepository serviceRepository;
    private TestRepo testRepo;

    @Before
    public void init() {
        serviceRepository = new ServiceRepository();
        testRepo = new TestRepo();
    }

    @Test
    public void testBoxDefaultValue() {
        assertEquals(serviceRepository.getBox().size(), 0);
    }

    @Test
    public void testAdd() {
        serviceRepository.add(testRepo);
        assertEquals(serviceRepository.getBox().size(), 1);
    }

    @Test
    public void testRemoveTrue() {
        serviceRepository.add(testRepo);
        serviceRepository.remove(testRepo);
        assertFalse(serviceRepository.getBox().contains(testRepo));
    }

    @Test
    public void testRemoveFalse() {
        TestRepo testRepo1 = new TestRepo();
        serviceRepository.add(testRepo);
        serviceRepository.remove(testRepo1);
        assertTrue(serviceRepository.getBox().contains(testRepo));
    }
}
