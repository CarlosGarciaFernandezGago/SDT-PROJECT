package domain;

import java.util.*;
public class Station {
    public final String id, name;
    private final List<Bike> bikes = new ArrayList<>();
    public Station(String id, String name){ this.id=id; this.name=name; }
    public void addBike(Bike b){ bikes.add(b); }
    public Bike findAvailableBike(){
        return bikes.stream().filter(Bike::isAvailable).findFirst()
                .orElseThrow(() -> new IllegalStateException("No bikes available"));
    }
}
