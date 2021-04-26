import org.junit.Test;

import static org.junit.Assert.*;

public class CityTest {

    @Test
    public void distanceTo() {
        City city = new City(60, 200);
        City city1 = new City(180, 200);
        assertEquals(120, city1.distanceTo(city));
    }

    @Test
    public void testToString() {
        City city = new City(60, 200);
        assertEquals("60, 200", city.toString());
    }
}