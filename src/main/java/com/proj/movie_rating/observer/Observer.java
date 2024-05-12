package com.proj.movie_rating.observer;

/**
 * Interface for objects that observe changes in observable objects.
 */
public interface Observer {

    /**
     * Called when the observer is notified by an Observable object.
     */
    void update();
}
