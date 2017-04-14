/**
 * Created by chen4393 on 4/12/17.
 */
public class VesselEvent implements Event {

    private int currPort;

    private Vessel vessel;

    public VesselEvent(Vessel vessel) {
        this.vessel = vessel;
    }

    public void run() {

        /* cause the vessel associated with it to look at its shipments list
         * to calculate how much money was made off of the current shipment */
        for ()

        /* remove the shipments */

        /* look at where the oldest shipment is going to */

        /* start loading the vessel with Shipments going to that Port */

        /* If the vessel reaches its departure capacity,
        the VesselEvent will create a new VesselEvent and schedule it (via the agenda)
        for the arrival at the next stop at a time in the future depending on the distance to that port
        from the current one. */

        /* If the vessel hasn’t reached its departure capacity
        by the time its max wait time has occurred,
        the vessel will depart on its own */
    }
}
