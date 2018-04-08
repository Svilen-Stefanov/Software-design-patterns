package edu.tum.cs.i1.eist.subject;

import java.util.HashSet;
import java.util.Set;

import edu.tum.cs.i1.eist.observer.Observer;

public abstract class Subject {
	
	public Set<Observer> observers = new HashSet<Observer>();

	public void subscribe(Observer observer) {
		observers.add(observer);
		System.out.println("Got a new Observer " + observer);
	}

	public void unsubscribe(Observer observer) {
		observers.remove(observer);
		System.out.println("Removed an Observer " + observer);
	}

	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update();
			System.out.println("Notifying Observer " + observer);
		}
	}
}
