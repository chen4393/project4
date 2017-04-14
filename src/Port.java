/**
 * Created by chaoranchen on 4/10/17.
 */
public class Port {
	private String name;
	private int[] location;
	private int shipmentsPerDay;

	private Q2 q;

	public Port(String name, int x, int y, int shipmentsPerDay) {
		this.name = name;
		location = new int[2];
		location[0] = x;
		location[1] = y;
		this.shipmentsPerDay = shipmentsPerDay;
		q = new Q2();
	}

	public String getName() {
		return name;
	}

	public int[] getLocation() {
		return location;
	}

	public int getShipmentsPerDay() {
		return shipmentsPerDay;
	}

	public Q2 getQ() {
		return q;
	}
}