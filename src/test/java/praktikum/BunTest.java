package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    Bun bun = new Bun();
    @Test
    public void testGetName(){
        bun.getName()
    }

}