package notify;
import java.util.*;
public class NotificationCenter {
    private final List<Observer> observers = new ArrayList<>();
    public void subscribe(Observer o){ if(!observers.contains(o)) observers.add(o); }
    public void unsubscribe(Observer o){ observers.remove(o); }
    public void publish(EventType t, Object payload){
        for(Observer o: observers) o.onEvent(t, payload);
    }
}
