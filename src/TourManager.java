import java.util.ArrayList;

/**
 * Created by shreyas on 4/26/14.
 * <p>
 * Tour manager class for travelling salesman problem
 * which holds the cities of the tour. This is needed as
 * the cities are to be interlinked with in the grid
 */


public class TourManager {

    // holds our cities
    private static ArrayList<City> destinationCities = new ArrayList<>();

    // adds a destination city
    public static void addCity(City city) {
        destinationCities.add(city);
    }

    // get a city
    public static City getCity(int index) {
        return destinationCities.get(index);
    }

    // get the number of destination cities
    public static int numberOfCities() {
        return destinationCities.size();
    }
} // End of class TourManager

