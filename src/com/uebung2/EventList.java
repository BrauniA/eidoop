package com.uebung2;

import java.util.Comparator;
import java.util.LinkedList;

public class EventList<E> implements IEventQueue<E> {
    private final LinkedList<Entry<E>> queue = new LinkedList<>();

    @Override
    public void enqueue(Double time, E event) {
        EventEntry<E> entry = new EventEntry<>(time, event);
        queue.add(entry);
        queue.sort(new EntryComparator());
    }

    @Override
    public Entry<E> dequeue() {
        return queue.remove();
    }

    class EntryComparator implements Comparator<Entry<E>> {

        @Override
        public int compare(Entry<E> entry1, Entry<E> entry2) {
            return entry1.getTime().compareTo(entry2.getTime());
        }
    }
}
