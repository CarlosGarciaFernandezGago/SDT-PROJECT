package domain;

import state.*;
import notify.*;

public class Bike {
    public final String id;
    private BikeState state;
    private final NotificationCenter bus;

    public Bike(String id, NotificationCenter bus){
        this.id = id; this.bus = bus; this.state = new AvailableState();
    }
    public void setState(BikeState s){ this.state = s; }
    public boolean isAvailable(){ return state instanceof AvailableState; }

    // simple versions (no return objects for brevity)
    public void reserve(User u){ state.reserve(this, u); bus.publish(EventType.RESERVED, this); }
    public void startRide(User u){ state.startRide(this, u); bus.publish(EventType.STARTED, this); }
    public void finishRide(User u, int minutes, double km, pricing.PricingStrategy ps){
        state.finishRide(this, u);
        Trip trip = new Trip("T-"+System.nanoTime(), u, this, minutes, km);
        double amount = ps.price(minutes, km);
        trip.setPrice(amount);
        var pay = new factory.PaymentServiceFactory().create();
        var receipt = pay.pay(amount);
        bus.publish(EventType.FINISHED, trip);
        System.out.println("[PAYMENT] amount="+amount+" ok="+receipt.ok);
    }
    public void markMaintenance(){ state.markMaintenance(this); bus.publish(EventType.MAINTENANCE, this); }
}
