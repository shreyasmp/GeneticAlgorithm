/**
 * Created by shreyas on 4/26/14.
 * <p>
 * this class manages algorithms for evolving population
 * By defining a crossover function and mutation function for the
 * parent population to yield fittest child tours with best result
 */
public class GeneticAlgorithm {

    // Genetic Algorithm parameters, this can change as needed by programmer
    private static final double mutationRate = 0.015;
    private static final int tournamentSize = 5;
    private static final boolean elitism = true; // The best ones produced

    // evolves a population over one generation
    public static Population evolvePopulation(Population pop) {
        Population newPopulation = new Population(pop.populationSize(), false);
        int elitismOffset;
        // keep best individual if elitism is enabled
        if (elitism) {
            newPopulation.saveTour(0, pop.getFittest());
            elitismOffset = 1;
        }
        // crossover population
        // loop over the new population size and create individuals from
        // current population
        // parents cross over
        for (int i = elitismOffset; i < newPopulation.populationSize(); i++) {
            Tour parent1 = tournamentSelection(pop);
            Tour parent2 = tournamentSelection(pop);
            Tour child = crossover(parent1, parent2);
            newPopulation.saveTour(i, child);
        }

        // mutate the new population a bit to add some new genetic material
        for (int i = elitismOffset; i < newPopulation.populationSize(); i++) {
            mutate(newPopulation.getTour(i));
        }
        return newPopulation;
    }

    private static Tour crossover(Tour parent1, Tour parent2) {

        Tour child = new Tour();

        // start and end sub tour position for parent1 tour
        int startPos = (int) (Math.random() * parent1.tourSize());
        int endPos = (int) (Math.random() * parent1.tourSize());

        // loop and add the sub tour from parent1 to our child
        for (int i = 0; i < child.tourSize(); i++) {
            if (startPos < endPos && i > startPos && i < endPos) {
                child.setCity(i, parent1.getCity(i));
            } else if (startPos > endPos) { // if start position is larger
                if (!(i < startPos && i > endPos)) {
                    child.setCity(i, parent1.getCity(i));
                }
            }
        }

        // loop through parent2 city tour
        for (int i = 0; i < parent2.tourSize(); i++) {
            if (!child.containsCity(parent2.getCity(i))) { // if child doesnt have the city add it
                for (int j = 0; j < child.tourSize(); j++) {
                    if (child.getCity(j) == null) { // spare position found, add city
                        child.setCity(j, parent2.getCity(i));
                        break;
                    }
                }
            }
        }
        return child;
    }

    // Mutation function using swap mutation
    private static void mutate(Tour tour) {
        // loop through tour cities
        for (int tourPosition = 0; tourPosition < tour.tourSize(); tourPosition++) {
            // apply mutation rate
            if (Math.random() < mutationRate) {
                // get a second random position in tour
                int tourPosition2 = (int) (tour.tourSize() * Math.random());

                // cities at target position in tour
                City city1 = tour.getCity(tourPosition);
                City city2 = tour.getCity(tourPosition2);

                // swap the cities
                tour.setCity(tourPosition2, city1);
                tour.setCity(tourPosition, city2);
            }
        }
    }

    // selects candidate tour from crossover
    private static Tour tournamentSelection(Population pop) {
        // create tournament population
        Population tournament = new Population(tournamentSize, false);
        // for each place in tournament get random candidate tour and add it
        for (int i = 0; i < tournamentSize; i++) {
            int randomID = (int) (Math.random() * pop.populationSize());
            tournament.saveTour(i, pop.getTour(randomID));
        }
        // get fittest tour
        return tournament.getFittest();
    }
}
