package com.uebung2;

public class UnsortedArrayQueue<E> implements IEventQueue<E> {
    private EventEntry<E>[] entries;
    private int currentIndex = 0;

    public UnsortedArrayQueue() {
        entries = new EventEntry[100];
    }

    @Override
    public void enqueue(Double time, E event) {
        // Add the event to the array
        EventEntry<E> entry = new EventEntry<>(time, event);
        entries[currentIndex] = entry;
        currentIndex += 1;

        // Check if the array still has any size left
        if (currentIndex >= entries.length) {
            EventEntry<E>[] newEntries = new EventEntry[entries.length + 100];
            System.arraycopy(entries, 0, newEntries, 0, currentIndex);
            entries = newEntries;
        }
    }

    @Override
    public EventEntry<E> dequeue() {
        // Find the element with the lowest time
        int elementIndex = 0;
        Double lowestTime = Double.MAX_VALUE;
        for (int i = 0; i < currentIndex; i++) {
            if (entries[i].getTime() < lowestTime) {
                lowestTime = entries[i].getTime();
                elementIndex = i;
            }
        }

        // Save the element with the lowest time
        EventEntry<E> lowestTimeEntry = entries[elementIndex];

        // Rearrange the following elements
        if (currentIndex - 1 - elementIndex >= 0)
            System.arraycopy(entries, elementIndex + 1, entries, elementIndex, currentIndex - 1 - elementIndex);

        // Remove the last element of the array
        currentIndex -= 1;
        entries[currentIndex] = null;

        // Shrink the list
        if (currentIndex <= entries.length - 200) {
            EventEntry<E>[] newEntries = new EventEntry[entries.length - 100];
            System.arraycopy(entries, 0, newEntries, 0, currentIndex);
            entries = newEntries;
        }

        return lowestTimeEntry;
    }
}
