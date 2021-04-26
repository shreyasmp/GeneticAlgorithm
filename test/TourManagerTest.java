import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TourManagerTest {

    @Test
    public void addCity() {
        City city = new City(60, 200);
        City city1 = new City(180, 200);
        TourManager.addCity(city);
        TourManager.addCity(city1);
        assertNotNull(TourManager.destinationCities);
    }

    @Test
    public void getCity() {
        addCities();
        City city1 = new City(180, 200);
        assertEquals(city1.toString(), TourManager.getCity(1).toString());
    }

    @Test
    public void numberOfCities() {
        assertEquals(5, TourManager.destinationCities.size());
    }

    private void addCities() {
        City city = new City(60, 200);
        City city1 = new City(180, 200);
        City city2 = new City(80, 180);
        TourManager.destinationCities.add(city);
        TourManager.destinationCities.add(city1);
        TourManager.destinationCities.add(city2);
    }
}