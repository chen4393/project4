/**
 * Created by chen4393 on 4/12/17.
 */
public class VesselEvent implements Event {

	private int currPort;

	private Vessel vessel;

	public VesselEvent(int currPort, Vessel vessel) {
		this.currPort = currPort;
		this.vessel = vessel;
	}

	public void run() {

		/* cause the vessel associated with it to look at its shipments list
		 * to calculate how much money was made off of the current shipment */
		int totalMoney = vessel.getMoney();
        //System.out.println("totalMoney: " + totalMoney);

		/* remove the shipments */
		vessel.removeShipments();

		/* look at where the oldest shipment is going to */
		Shipment oldestShipment = null;

        int qSize = VesselSim.ports[currPort].getQ().length();

        int earliestTime = Integer.MAX_VALUE;
		for (int i = 0; i < qSize; i++) {
			Shipment tempShipment = (Shipment)VesselSim.ports[currPort].getQ().remove();
			if (tempShipment == null)   continue;
			if (tempShipment.getCreationTime() < earliestTime && tempShipment.getDestinationPort() != currPort) {
				earliestTime = (int)tempShipment.getCreationTime();
				oldestShipment = tempShipment;
			}
			VesselSim.ports[currPort].getQ().add(tempShipment);
		}

		int dest = 0;
		if (oldestShipment != null && oldestShipment.getDestinationPort() != currPort) {
			dest = oldestShipment.getDestinationPort();
		}

        System.out.println("currPort: " + currPort + " dest: " + dest);
        int interval = getProcessingTime(currPort, dest);

		/* start loading the vessel with Shipments going to that Port */
/*
		for (int i = 0; i < qSize; i++) {
			Shipment tempShipment = (Shipment)VesselSim.ports[currPort].getQ().remove();
			if (tempShipment == null)   continue;
			if (tempShipment.getDestinationPort() == dest) {
				boolean isSuccess = vessel.addShipment(tempShipment);
				if (!isSuccess) {
					break;
				}
			} else {
				VesselSim.ports[currPort].getQ().add(tempShipment);
			}
		}
*/
		/* If the vessel reaches its departure capacity,
		 * the VesselEvent will create a new VesselEvent and schedule it (via the agenda)
		 * for the arrival at the next stop at a time in the future depending on the distance to that port
		 * from the current one */

		/* If the vessel hasn’t reached its departure capacity
		* by the time its max wait time has occurred,
		* the vessel will depart on its own */

		VesselSim.agenda.add(new VesselEvent(dest, vessel), interval);

		System.out.println("Vessel Event Port: " + dest +
				", Time is: " + VesselSim.agenda.getCurrentTime() + ", Next Ferry in: " + interval);
	}

	private int getProcessingTime(int src, int dest) {
	    int dx = (VesselSim.ports[dest].getLocation()[0] - VesselSim.ports[src].getLocation()[0]);
	    int dy = (VesselSim.ports[dest].getLocation()[1] - VesselSim.ports[src].getLocation()[1]);
        int d2 = dx * dx + dy * dy;
		double d = Math.sqrt(d2);
        int t = (int)(d / vessel.getSpeed() * 60 + 0.5);
		return t;
	}
}
