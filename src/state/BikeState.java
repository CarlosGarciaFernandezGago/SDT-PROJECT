package state;
import domain.*;

public interface BikeState {
    void reserve(Bike b, User u);
    void startRide(Bike b, User u);
    void finishRide(Bike b, User u);
    void markMaintenance(Bike b);
}
