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
		/* generate a destination port by random distribution */
		do {
			int trialNum = (int)(1000 * Math.random());
			if (trialNum == 0) {
				destinationPort = 6;    // 0.1% chance to get to Moon
			} else {
				int trialNum2 = (int)(9 * Math.random());
				if (trialNum2 >= 6) {
					trialNum2++; // skip Moon
				}
				destinationPort = trialNum2;
			}
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
