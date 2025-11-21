package state;
import domain.*;

public class MaintenanceState implements BikeState {
    @Override public void reserve(Bike b, User u){ throw new IllegalStateException("Under maintenance"); }
    @Override public void startRide(Bike b, User u){ throw new IllegalStateException("Under maintenance"); }
    @Override public void finishRide(Bike b, User u){ throw new IllegalStateException("Under maintenance"); }
    @Override public void markMaintenance(Bike b){ /* already in maintenance */ }
}
