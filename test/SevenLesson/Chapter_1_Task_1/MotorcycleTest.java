package SevenLesson.Chapter_1_Task_1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(JUnit4.class)
public class MotorcycleTest {

    private Motorcycle motorcycle;

    @Before
    public void init() {
        motorcycle = new Motorcycle();
    }

    @Test
    public void testBrandDefaultValue() {
        assertNull(motorcycle.getBrand());
    }

    @Test
    public void testModelDefaultValue() {
        assertNull(motorcycle.getModel());
    }

    @Test
    public void testColourDefaultValue() {
        assertNull(motorcycle.getMotorcycleColour());
    }

    @Test
    public void testPriceDefaultValue() {
        assertEquals(motorcycle.getPrice(), 0);
    }

    @Test
    public void testSetBrand() {
        String brand = "BMW";
        motorcycle.setBrand(brand);
        assertEquals(motorcycle.getBrand(), brand);
    }

    @Test
    public void testSetModel() {
        String model = "S 1000 RR";
        motorcycle.setModel(model);
        assertEquals(motorcycle.getModel(), model);
    }

    @Test
    public void testSetColour() {
        motorcycle.setMotorcycleColour(MotorcycleColour.BLACK);
        assertEquals(motorcycle.getMotorcycleColour(), MotorcycleColour.BLACK);
    }

    @Test
    public void testSetPrice() {
        int price = 1000;
        motorcycle.setPrice(price);
        assertEquals(motorcycle.getPrice(), price);
    }
}
