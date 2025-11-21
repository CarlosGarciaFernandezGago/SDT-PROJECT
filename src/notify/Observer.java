package notify;
public interface Observer {
    void onEvent(EventType type, Object payload);
}
