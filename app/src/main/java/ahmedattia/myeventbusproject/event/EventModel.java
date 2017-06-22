package ahmedattia.myeventbusproject.event;

/**
 * Created by Ahmed Attia on 29/05/2017.
 */

public class EventModel {
    private  String MessageEvent;

    public EventModel(String messageEvent) {
        MessageEvent = messageEvent;
    }

    public String getMessageEvent() {
        return MessageEvent;
    }

    public void setMessageEvent(String messageEvent) {
        MessageEvent = messageEvent;
    }
}
