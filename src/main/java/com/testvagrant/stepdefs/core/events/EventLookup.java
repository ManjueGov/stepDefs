package com.testvagrant.stepdefs.core.events;


import java.util.HashMap;
import java.util.Map;

public class EventLookup {

    private Map<Integer,Events> eventsMap = new HashMap<>();
    private EventLookup() {

    }

    public static EventLookup eventLookup() {
        return new EventLookup();
    }

    public EventLookup load() {
        initEventMap();
        return this;
    }

    public Events getEvent(int eventCode) {
        return eventsMap.get(eventCode);
    }

    private void initEventMap() {
        eventsMap.put(1, Events.TAP);
        eventsMap.put(2,Events.TAP);
        eventsMap.put(3,Events.SCROLL);
        eventsMap.put(4,Events.SCROLL);
        eventsMap.put(5,Events.SWIPE);
        eventsMap.put(6,Events.SWIPE);
        eventsMap.put(7,Events.SLIDE);
        eventsMap.put(8,Events.TYPE);
    }
}
