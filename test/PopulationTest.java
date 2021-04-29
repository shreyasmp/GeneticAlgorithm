import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PopulationTest {

    Population population = new Population(10, true);
    Tour tour = new Tour();

    @Before
    public void setUp() {
        City city = new City(60, 200);
        City city1 = new City(180, 200);
        tour.tour.add(city);
        tour.tour.add(city1);
        population.tours[0].fitness = 9.8;
        population.tours[0].distance = 25;

        population.tours[1].fitness = 11.2;
        population.tours[1].distance = 30;

        population.tours = new Tour[2];
    }

    @Test
    public void getTour() {
        assertEquals(population.tours[0], population.getTour(0));
    }

    @Test
    public void populationSize() {
        assertEquals(2, population.populationSize());
    }
}