package edu.tum.cs.i1.eist;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import edu.tum.cs.i1.eist.car.Car;

public class AnotherCollision extends CollisionStrategy {

	@Override
	public Car detectCollision(Car userCar, Car roboCar) {
		Point     p1 = userCar.getPosition( );
		Dimension d1 = userCar.getSize( );
		Rectangle r1 = new Rectangle(p1, d1);
		
		
		Point     p2 = roboCar.getPosition( );
		Dimension d2 = roboCar.getSize( );
		Rectangle r2 = new Rectangle(p2, d2);
	
		
		if (r1.intersects(r2)) {
			if (p1.x < p2.x){
				return userCar;
			}else{
				return roboCar;
			}
		}
		return null;
	}

	@Override
	public String getName() {
		return "AnotherCollision";
	}

}
