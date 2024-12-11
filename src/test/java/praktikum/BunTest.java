package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BunTest {
    @Test
    public void testGetName(){
        Bun bun = new Bun("Burger", 5.0f);
        assertEquals("Burger", bun.getName());
    }
    @Test
    public void testGetPrice(){
        Bun bun = new Bun("Burger", 5.0f);
        assertEquals(5.0f, bun.getPrice(), 0.01);
    }

}