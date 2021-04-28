package com.uebung2;

public class EventEntry<E> implements IEventQueue.Entry<E> {
    private final E event;
    private final Double time;

    public EventEntry(Double time, E event) {
        this.event = event;
        this.time = time;
    }

    @Override
    public Double getTime() {
        return time;
    }

    @Override
    public E getEvent() {
        return event;
    }

    @Override
    public String toString() {
        return time + " - " + event.toString();
    }
}
