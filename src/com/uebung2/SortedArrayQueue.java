package com.uebung2;

public class SortedArrayQueue<E> implements IEventQueue<E>{
    private EventEntry<E>[] entries;
    private int currentIndex = 0;

    public SortedArrayQueue() {
        entries = new EventEntry[100];
    }

    @Override
    public void enqueue(Double time, E event) {
        // Add the event to the array
        EventEntry<E> entry = new EventEntry<>(time, event);

        // If the queue is empty we will just insert it at the first index
        if (currentIndex == 0) {
            entries[currentIndex] = entry;
            currentIndex += 1;
            return;
        }

        // Search the position for the new entry
        int insertIndex = 0;
        for (int i = 0; i < currentIndex; i++) {
            if (entries[i].getTime() < entry.getTime()) {
                insertIndex = i;
                break;
            }
        }

        // Move all elements starting by insertIndex up
        for (int i = currentIndex; i > insertIndex; i--) {
            entries[i] = entries[i - 1];
        }
        currentIndex += 1;
        entries[insertIndex] = entry;

        // Check if the array still has any size left
        if (currentIndex >= entries.length) {
            EventEntry<E>[] newEntries = new EventEntry[entries.length + 100];
            System.arraycopy(entries, 0, newEntries, 0, currentIndex);
            entries = newEntries;
        }
    }

    @Override
    public EventEntry dequeue() {
        // Save the element with the lowest time
        EventEntry<E> lowestTimeEntry = entries[currentIndex];

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
