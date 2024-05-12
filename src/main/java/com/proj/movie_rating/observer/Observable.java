package com.proj.movie_rating.observer;

/**
 * Interface for objects that can be observed by observers.
 */
public interface Observable {

    /**
     * Registers an observer to receive updates from this observable object.
     *
     * @param observer The observer to register.
     */
    void registerObserver(Observer observer);

    /**
     * Removes an observer from the list of observers.
     *
     * @param observer The observer to remove.
     */
    void removeObserver(Observer observer);

    /**
     * Notifies all registered observers about changes in this observable object.
     */
    void notifyObservers();
}
