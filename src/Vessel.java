import java.util.ArrayList;

/**
 * Created by chen4393 on 4/12/17.
 */
public class Vessel {

	/* vessel type */
	private String typeName;

	/* maximum weight: capacity in Kg */
	private int maxWeight;

	/* speed in Km/H */
	private int speed;

	/* cost per Km */
	private int unitCost;

	/* current weight */
	private int currWeight;

	/* time when created, wait time = getTotalWaitTime() - creationTime */
	private int creationTime;

	/* shipments list */
	private ArrayList<Shipment> list;

	public Vessel(String name) {
		typeName = name;

		if (name.equals("Canoe")) {
			set(1000, 10,1);
		} else if (name.equals("Yacht")) {
			set(2000, 60, 2000);
		} else if (name.equals("Galleon")) {
			set(15000, 15, 100);
		} else if (name.equals("Barge")) {
			set(1000000, 10,1000);
		} else if (name.equals("Freighter")) {
			set(2000000, 5, 1000);
		} else if (name.equals("Airplane")) {
			set(50000, 850, 10000);
		} else if (name.equals("Carrier Pigeon Team")) {
			set(1000, 10, 0);
		} else if (name.equals("Rocket")) {
			set(10000, 2000, 100000);
		}

		currWeight = 0;

		creationTime = (int)VesselSim.agenda.getCurrentTime();

		list = new ArrayList<Shipment>();
	}

	private void set(int maxWeight, int speed, int unitCost) {
		this.maxWeight = maxWeight;
		this.speed = speed;
		this.unitCost = unitCost;
	}

	/* get current load percentage of a ship */
	private double getC() {
		return currWeight / maxWeight;
	}

	/* get current wait time in minutes */
	private int getW() {
		return (int) (VesselSim.agenda.getCurrentTime() - creationTime);
	}

    /* loading the vessel with a given Shipment */
	public boolean addShipment(Shipment s) {
		if (!isFull()) {
			list.add(s);
			currWeight += s.getWeight();
			return true;
		} else {
			return false;
		}
	}

	public void removeShipments() {

	    ArrayList<Shipment> tempList = list;

		/* remove the shipments whose destination is the targetPort from the list */
		list = new ArrayList<Shipment>();

		currWeight = 0;
	}

	public boolean isFull() {
		return (getC() >= VesselSim.C) || (getW() >= VesselSim.W * 24 * 60);
	}

	public String getTypeName() {
		return typeName;
	}

	/* calculate how much money was made off of the current shipment */
    public int getMoney() {
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            Shipment tempShipment = list.get(i);
            result += tempShipment.getWeight();
        }
        return result;
    }

    public ArrayList<Shipment> getList() {
        return list;
    }

    public int getSpeed() {
        return speed;
    }
}
