/**
 * Created by chaoranchen on 4/12/17.
 */
public class VesselSim {

	public static PQ agenda = new PQ();

	public static Port[] ports;

	/* the percentage a ship needs to be full before departing */
	public static double C;

	/* the amount of time a ship will wait to reach capacity
	 * before leaving with the current cargo
	  * unit: day*/
	public static int W;

	/* transport vessel type */
	public static String Type;

	public static void main(String[] args) {

		C = 0.8;

		W = 2;

		Type = "Carrier Pigeon Team";

		/* ports configuration */
		ports = new Port[10];
		ports[0] = new Port("Minneapolis", 0, 0, 50);
		ports[1] = new Port("Saint Paul", 0, 10, 50);
		ports[2] = new Port("Antarctica", 0, -6000, 10);
		ports[3] = new Port("Japan", 4000, 4000, 100);
		ports[4] = new Port("Korea", 6000, 5000, 50);
		ports[5] = new Port("China", 5000, 6000, 1000);
		ports[6] = new Port("Moon", 0, 1000000, 0);
		ports[7] = new Port("Panama", 1000, 3000, 50);
		ports[8] = new Port("Hawaii", 2000, 2000, 50);
		ports[9] = new Port("Pirate Town", 3000, 3000, 100);

		for (int i = 0; i < ports.length; i++) {
			if (i != 6) {
				agenda.add(new ShipmentMaker(i), i);
			}
		}

		int numVessel = 0;
        if (Type.equals("Canoe")) {
            numVessel = 100;
        } else if (Type.equals("Yacht")) {
            numVessel = 10;
        } else if (Type.equals("Galleon")) {
            numVessel = 20;
        } else if (Type.equals("Barge")) {
            numVessel = 15;
        } else if (Type.equals("Freighter")) {
            numVessel = 10;
        } else if (Type.equals("Airplane")) {
            numVessel = 5;
        } else if (Type.equals("Carrier Pigeon Team")) {
            numVessel = 30;
        } else if (Type.equals("Rocket")) {
            numVessel = 10;
        }

        for (int i = 0; i < numVessel; i++) {
            int randNum = (int)(9 * Math.random());
            if (randNum >= 6)   randNum++;
            agenda.add(new VesselEvent(randNum, new Vessel(Type)), 10);
        }

		while (agenda.getCurrentTime() <= 100000) {
			agenda.remove().run();
		}

		Stat.printTotalProfit();
	}

}
