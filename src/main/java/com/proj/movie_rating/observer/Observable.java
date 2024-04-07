package com.proj.movie_rating.observer;

/**
 * Observable Interface
 */
public interface Observable {

    /**
     * for adding Observers
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * for removing Observers
     * @param observer
     */
    void removeObserver(Observer observer);

    /**
     * notify all the Observers
     */
    void notifyObservers();
}
