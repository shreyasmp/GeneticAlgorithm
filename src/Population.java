/**
 * Created by shreyas on 4/26/14.
 * <p>
 * Population class to hold a candidate tours and
 * manage a candidate tour population
 */

public class Population {

    // Holds population ot tours
    private Tour[] tours;

    // Construct a population
    Population(int populationSize, boolean initialise) {
        tours = new Tour[populationSize];

        if (initialise) {
            for (int i = 0; i < populationSize(); i++) {
                Tour newTour = new Tour();
                newTour.generateIndividual();
                saveTour(i, newTour);
            }
        }
    }

    // Saves a tour
    public void saveTour(int index, Tour tour) {
        tours[index] = tour;
    }

    // gets a tour from population
    public Tour getTour(int index) {
        return tours[index];
    }

    // get population size
    public int populationSize() {
        return tours.length;
    }

    // gets the best tour in population
    public Tour getFittest() {
        Tour fittest = tours[0];

        for (int i = 1; i < populationSize(); i++) {
            if (fittest.getFitness() <= getTour(i).getFitness()) {
                fittest = getTour(i);
            }
        }
        return fittest;
    }
} // End of class population
