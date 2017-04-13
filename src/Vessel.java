/**
 * Created by chen4393 on 4/12/17.
 */
public class Vessel {

    private String name;

    /* capacity in Kg */
    private int capacity;

    /* speed in Km/H */
    private int speed;

    /* cost per Km */
    private int cost;

    public Vessel(String name, int capacity, int speed, int cost) {
        this.name = name;
        this.capacity = capacity;
        this.speed = speed;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSpeed() {
        return speed;
    }

    public int getCost() {
        return cost;
    }
}
