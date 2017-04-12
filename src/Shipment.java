/**
 * Created by chaoranchen on 4/10/17.
 */
public class Shipment {
    private int weight;

    private double creationTime;

    private int destinationPort;

    private int creationPort;

    public Shipment(int w, double t, int c) {
        weight = w;
        creationTime = t;
        creationPort = c;
        /* generate a random destination port */
        do {
            destinationPort = 10 * (int) Math.random();
        } while (destinationPort == creationPort);
    }

    public int getWeight() {
        return weight;
    }

    public double getCreationTime() {
        return creationTime;
    }

    public int getDestinationPort() {
        return destinationPort;
    }

    public int getCreationPort() {
        return creationPort;
    }
}
