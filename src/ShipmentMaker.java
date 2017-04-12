/**
 * Created by chaoranchen on 4/10/17.
 */
public class ShipmentMaker implements Event {

    /* creation port */
    private int creationPort;

    public ShipmentMaker(int creationPort) {
        this.creationPort = creationPort;
    }

    @Override
    public void run() {
        /* create a shipment */
        Shipment s = new Shipment(weightGenerator(), VesselSim.agenda.getCurrentTime(), creationPort);
    }

    private int weightGenerator() {
        return intRandomInterval(1, 1000);
    }

    private int intervalGenerator(double mean) {
        int randNum = (int)(100 * Math.random());
        double res = 0;
        if (randNum >= 0 && randNum <= 9) {
            res = mean / 4; // 10%
        } else if (randNum >= 10 && randNum <= 24) {
            res = mean / 2; // 15%
        } else if (randNum >= 25 && randNum <= 44) {
            res = 4 * mean / 5; // 20%
        } else if (randNum >= 45 && randNum <= 54) {
            res = mean; // 10%
        } else if (randNum >= 55 && randNum <= 74) {
            res = 6 * mean / 5; // 20%
        } else if (randNum >= 75 && randNum <= 89) {
            res = 3 * mean / 2; // 15%
        } else if (randNum >= 90 && randNum <= 99) {
            res = 7 * mean / 4; // 10%
        }
        return (int)res;
    }

    public static int intRandomInterval(int low, int high) {
        return (int) Math.floor((high - low) * Math.random() + low + 0.5);
    }
}
