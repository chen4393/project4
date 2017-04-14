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



	/*  */

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

	public boolean addShipment(Shipment s) {
		if (!isFull()) {
			list.add(s);
			currWeight += s.getWeight();
			return true;
		} else {
			return false;
		}
	}

	public Shipment[] removePassengersAtPort(int targetPort) {

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

	public boolean isFull() {
		return (getC() >= VesselSim.C) || (getW() >= VesselSim.W * 24 * 60);
	}

	public String getTypeName() {
		return typeName;
	}

	public int getSize() {
		return list.size();
	}

	/* calculate how much money was made off of the current shipment */

}
