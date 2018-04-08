package edu.tum.cs.i1.eist.vehicle;

public class VehicleFacade {
	public void startVehicle(Vehicle vehicle){
		vehicle.brake.brakeAndHold();
		vehicle.cockpit.pressStartButton();
		vehicle.ignition.start();
		vehicle.engine.start();
		vehicle.radio.play();
	}
}
