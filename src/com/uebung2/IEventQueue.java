package com.uebung2;

public interface IEventQueue<E> {

    void enqueue (Double time, E event);

    IEventQueue.Entry<E> dequeue ();

    public interface Entry<E> {

        Double getTime();

        E getEvent();

    }

}