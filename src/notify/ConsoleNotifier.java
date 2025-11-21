package notify;
public class ConsoleNotifier implements Observer {
    @Override public void onEvent(EventType type, Object payload) {
        System.out.println("[EVENT] " + type + " -> " + payload.getClass().getSimpleName());
    }
}
