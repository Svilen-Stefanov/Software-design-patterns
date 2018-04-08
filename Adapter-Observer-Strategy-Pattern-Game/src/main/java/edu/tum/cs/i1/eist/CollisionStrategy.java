package edu.tum.cs.i1.eist;

import java.util.ArrayList;

import edu.tum.cs.i1.eist.car.Car;

public abstract class CollisionStrategy {

    private static ArrayList<Object> STRATEGIES = null;

    public abstract Car detectCollision(Car userCar, Car roboCar);

    public abstract String getName();

    public String toString() {
        return getName();
    }

    public static ArrayList<Object> getSTRATEGIES() {
        if (STRATEGIES == null) {
        	STRATEGIES = new ArrayList<Object>();
        	STRATEGIES.add(new DefaultCollision());
        	STRATEGIES.add(new AnotherCollision());
        }
        return STRATEGIES;
    }
}