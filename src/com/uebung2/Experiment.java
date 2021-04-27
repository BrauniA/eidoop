package com.uebung2;

public class Experiment {
    IEventQueue<String> events;

    public Experiment(IEventQueue<String> queue) {
        events = queue;
    }

    public float initialize(int initialSize) {
        long total = 0L;
        for (int i=0; i < initialSize; i++) {
            long start = System.currentTimeMillis();
            events.enqueue(Math.random(), "test" + i);
            total += (System.currentTimeMillis() - start);
        }

        return ((float) total);
    }

    public float evaluate(int repetitions) {
        long total = 0L;
        for (int i = 0; i < repetitions; i++) {
            long start = System.currentTimeMillis();
            events.enqueue(Math.random(), "test" + i);
            events.dequeue();
            total += (System.currentTimeMillis() - start);
        }

        return ((float) total);
    }

    public static void main(String[] args) {
        Experiment exp = new Experiment(new SortedArrayQueue<>());
        int initialValue = 100000;
        int repetitions = 1000;
        System.out.println("Initializing took an average of " + exp.initialize(initialValue) + "ms for " + initialValue + " initial entries SortedArrayQueue");
        System.out.println("Evaluate took an average of " + exp.evaluate(repetitions) + "ms for " + repetitions + " repetitions SortedArrayQueue");

        Experiment exp2 = new Experiment(new UnsortedArrayQueue<>());
        System.out.println("Initializing took an average of " + exp2.initialize(initialValue) + "ms for " + initialValue + " initial entries UnsortedArrayQueue");
        System.out.println("Evaluate took an average of " + exp2.evaluate(repetitions) + "ms for " + repetitions + " repetitions UnsortedArrayQueue");

        Experiment exp3 = new Experiment(new EventList<>());
        System.out.println("Initializing took an average of " + exp3.initialize(initialValue) + "ms for " + initialValue + " initial entries EventList");
        System.out.println("Evaluate took an average of " + exp3.evaluate(repetitions) + "ms for " + repetitions + " repetitions EventList");
    }
}