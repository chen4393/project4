/**
 * Created by chaoranchen on 4/12/17.
 */
public class VesselSim {

    public static PQ agenda = new PQ();

    public static Port[] ports;

    public static void main(String[] args) {
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

        agenda.add(new ShipmentMaker(0), 0);
        agenda.add(new ShipmentMaker(1), 1);
        agenda.add(new ShipmentMaker(2), 2);

        while (agenda.getCurrentTime() <= 100) {
            agenda.remove().run();
        }
    }

}
