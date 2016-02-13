package SevenLesson.Chapter_3_Task_7;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class ShopTest {
    private Shop shop;

    @Before
    public void init() {
        shop = new Shop();
    }

    @Test
    public void discountTestProcent5() {
        assertEquals(shop.discount(50000)[0], "5%");
    }

    @Test
    public void discountTestSum5() {
        assertEquals(shop.discount(50000)[1], "47500.0");
    }

    @Test
    public void discountTestProcent10() {
        assertEquals(shop.discount(110000)[0], "10%");
    }

    @Test
    public void discountTestProcent() {
        assertEquals(shop.discount(110000)[1], "99000.0");
    }
}
