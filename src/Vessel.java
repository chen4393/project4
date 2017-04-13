import java.util.ArrayList;

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
    private int unitCost;

    private int maxWeight;

    /* what capacity a vessel should be filled before departing */
    private int C;

    

    /* shipments list */
    private ArrayList<Shipment> list;

    public Vessel(String name, int capacity, int speed, int unitCost) {
        this.name = name;
        this.capacity = capacity;
        this.speed = speed;
        this.unitCost = unitCost;
        list = new ArrayList<Shipment>();
    }

    public boolean addShipment(Shipment s) {
        if (!isFull()) {
            list.add(s);
            return true;
        } else {
            return false;
        }
    }

    public Shipment[] removePassengersAtIsland(int targetPort) {

        /* buffer the shipments whose destination is the targetPort into a temporary list */
        ArrayList<Shipment> tempList = new ArrayList<Shipment>();
        for (int i = 0; i < list.size(); i++) {
            Shipment tempShipment = list.get(i);
            if (tempShipment.getDestinationPort() == targetPort) {
                tempList.add(tempShipment);
            }
        }

        /* remove the shipments whose destination is the targetPort from the list */
        for (int i = 0; i < tempList.size(); i++) {
            Shipment tempShipment = tempList.get(i);
            list.remove(tempShipment);
        }

        /* dump the shipments whose destination is the targetPort into an array */
        Shipment[] result = new Shipment[tempList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = tempList.get(i);
        }

        return result;
    }

    public boolean isFull() { return list.size() >= capacity; }

    public String getName() { return name; }

    public int getCapacity() { return capacity; }

    public int getSpeed() { return speed; }

    public int getunitCost() { return unitCost; }

    public int getSize() { return list.size(); }

    /* calculate how much money was made off of the current shipment */

}
