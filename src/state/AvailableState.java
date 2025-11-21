package state;
import domain.*;

public class AvailableState implements BikeState {
    @Override public void reserve(Bike b, User u){ b.setState(new ReservedState()); }
    @Override public void startRide(Bike b, User u){ throw new IllegalStateException("Reserve first"); }
    @Override public void finishRide(Bike b, User u){ throw new IllegalStateException("Not in use"); }
    @Override public void markMaintenance(Bike b){ b.setState(new MaintenanceState()); }
}
