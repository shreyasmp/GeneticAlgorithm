/**
 * Created by shreyas on 4/26/14.
 * <p>
 * Problem defined is: Travelling salesman problem
 * using Genetic Algorithm with varied crossover and mutation of
 * parents and children
 * This class builds a city
 */

public class City {

    private int x;
    private int y;

    // constructs a randomly place city
    public City() {
        this.x = (int) (Math.random() * 200);
        this.y = (int) (Math.random() * 200);
    }

    // constructs a city at chosen x , y location
    City(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // gets city's x-coordinate
    private int getX() {
        return this.x;
    }

    // gets city's y-coordinate
    private int getY() {
        return this.y;
    }

    // gets distance to given city
    public long distanceTo(City city) {
        int xDistance = Math.abs(getX() - city.getX());
        int yDistance = Math.abs(getY() - city.getY());

        return (long) Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));
    }

    @Override
    public String toString() {
        return getX() + ", " + getY();
    }
} // End City class
