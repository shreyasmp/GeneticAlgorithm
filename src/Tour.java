import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shreyas on 4/26/14.
 * <p>
 * Generates a rough tour initially for travel and with the
 * fitness or utility function, the tour is improvised upon
 * better fitness value everytime
 */

public class Tour {

    // holds our tour of cities
    protected ArrayList<City> tour = new ArrayList<>();
    protected double fitness = 0.0;
    protected int distance = 0;

    // construct a blank tour
    Tour() {
        for (int i = 0; i < TourManager.numberOfCities(); i++) {
            tour.add(null);
        }
    }
    
    //sets a city in certain position within a tour
    public void setCity(int tourPosition, City city) {
        tour.set(tourPosition, city);
        fitness = 0.0;
        distance = 0;
    }

    // gets a city from tour
    public City getCity(int tourPosition) {
        return tour.get(tourPosition);
    }

    // create a random individual for population generation
    public void generateIndividual() {
        for (int cityIndex = 0; cityIndex < TourManager.numberOfCities(); cityIndex++) {
            setCity(cityIndex, TourManager.getCity(cityIndex));
        }

        Collections.shuffle(tour);
    }

    // gets the tours fitness
    public double getFitness() {
        if (fitness == 0) {
            fitness = 1 / (double) getDistance();
        }
        return fitness;
    }

    // get number of cities on our tour
    public int tourSize() {
        return tour.size();
    }

    // check if the tour contains a city
    public boolean containsCity(City city) {
        return tour.contains(city);
    }

    // gets the total distance of the tour
    public int getDistance() {
        if (distance == 0) {
            int tourDistance = 0;

            for (int cityIndex = 0; cityIndex < tourSize(); cityIndex++) {
                City fromCity = getCity(cityIndex);
                City destinationCity;

                if (cityIndex + 1 < tourSize()) {
                    destinationCity = getCity(cityIndex + 1);
                } else {
                    destinationCity = getCity(0);
                }

                tourDistance += fromCity.distanceTo(destinationCity);
            }
            distance = tourDistance;
        }
        return distance;
    }

    @Override
    public String toString() {
        StringBuilder geneString = new StringBuilder("|");
        for (int i = 0; i < tourSize(); i++) {
            geneString.append(getCity(i)).append("|");
        }
        return geneString.toString();
    }
} // End of class Tour

