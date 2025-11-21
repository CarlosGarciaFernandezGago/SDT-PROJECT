package state;
import domain.*;

public class InUseState implements BikeState {
    @Override public void reserve(Bike b, User u){ throw new IllegalStateException("Already in use"); }
    @Override public void startRide(Bike b, User u){ throw new IllegalStateException("Already riding"); }
    @Override public void finishRide(Bike b, User u){ b.setState(new AvailableState()); }
    @Override public void markMaintenance(Bike b){ b.setState(new MaintenanceState()); }
}
