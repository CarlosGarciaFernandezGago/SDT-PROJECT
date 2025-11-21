package domain;
public class Trip {
    public final String id;
    public final User user;
    public final Bike bike;
    public final int minutes;
    public final double km;
    private double price;
    public Trip(String id, User user, Bike bike, int minutes, double km){
        this.id=id; this.user=user; this.bike=bike; this.minutes=minutes; this.km=km;
    }
    public void setPrice(double p){ this.price=p; }
    public double getPrice(){ return price; }
}
