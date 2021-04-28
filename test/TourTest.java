import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TourTest {

    Tour tour = new Tour();

    @Before
    public void setUp() {
        City city = new City(60, 200);
        City city1 = new City(180, 200);
        tour.tour.add(city);
        tour.tour.add(city1);

        tour.tour.set(0, city);
        tour.tour.set(1, city1);

        tour.fitness = 9.8;
        tour.distance = 25;
    }

    @Test
    public void getCity() {
        City city = new City(60, 200);
        assertEquals(city.toString(), tour.getCity(0).toString());
    }

    @Test
    public void getFitness() {
        assertEquals(9.8, tour.getFitness(), 2.0);
    }

    @Test
    public void tourSize() {
        assertEquals(7, tour.tour.size());
    }

    @Test
    public void containsCity() {
        assertTrue(tour.containsCity(tour.tour.get(0)));
    }

    @Test
    public void getDistance() {
        assertEquals(25, tour.getDistance());
    }
}