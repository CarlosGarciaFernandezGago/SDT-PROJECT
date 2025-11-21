package state;
import domain.*;

public class ReservedState implements BikeState {
    @Override public void reserve(Bike b, User u){ throw new IllegalStateException("Already reserved"); }
    @Override public void startRide(Bike b, User u){ b.setState(new InUseState()); }
    @Override public void finishRide(Bike b, User u){ throw new IllegalStateException("Not in use"); }
    @Override public void markMaintenance(Bike b){ b.setState(new MaintenanceState()); }
}
