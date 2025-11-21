package app;

import domain.*;
import notify.*;
import pricing.*;
import factory.*;

public class Main {
    public static void main(String[] args) {
        NotificationCenter bus = new NotificationCenter();
        bus.subscribe(new ConsoleNotifier());

        Station st = new Station("S1", "Central");
        Bike b1 = new Bike("B-001", bus);
        Bike b2 = new Bike("B-002", bus);
        st.addBike(b1);
        st.addBike(b2);

        User u = new User("U1", "Carlos");

        // Reserve flow (STATE + OBSERVER)
        Bike picked = st.findAvailableBike();
        picked.reserve(u);       // Available -> Reserved (event: RESERVED)

        picked.startRide(u);     // Reserved -> InUse (event: STARTED)

        // Finish flow (STATE + STRATEGY + FACTORY + OBSERVER)
        PricingStrategy strategy = new TimePricing(); // try DistancePricing/PeakHoursPricing
        picked.finishRide(u, 23, 4.2, strategy); // InUse -> Available (event: FINISHED)
    }
}
