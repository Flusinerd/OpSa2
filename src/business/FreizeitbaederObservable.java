package business;

import observer.Observable;
import observer.Observer;

import java.util.Vector;

/**
 * Class that implements Observable
 * Extend from this and call notifyObservers when needed
 */
public class FreizeitbaederObservable implements Observable {
    private final Vector<Observer> observers = new Vector<>();

    @Override
    public void addObserver(Observer obs){
        // Do not add if already subscribed
        if (this.hasObserver(obs)) {
            return;
        }
        this.observers.add(obs);
    }

    /**
     * Checks if the observer is already in the list of observers
     * @param obs The observer to check for
     * @return If the observer is already in the list
     */
    private boolean hasObserver(Observer obs) {
        return observers.contains(obs);
    }

    /**
     * Removes a observer from the list of observers
     * @param obs Observer to remove
     */
    @Override
    public void removeObserver(Observer obs){
        // Only remove if the observer is already subscribed
        if (!this.hasObserver(obs)){
            return;
        }
        this.observers.remove(obs);
    }

    /**
     * Notify all observers
     */
    @Override
    public void notifyObservers() {
        // Call update() on all observers
        this.observers.forEach(Observer::update);
    }
}
