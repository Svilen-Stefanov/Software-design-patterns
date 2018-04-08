package edu.tum.cs.i1.eist.driver;

import edu.tum.cs.i1.eist.vehicle.VehicleFacade;
import edu.tum.cs.i1.eist.vehicle.Vehicle;

public class Driver {

	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle();		
		VehicleFacade v = new VehicleFacade();
		v.startVehicle(vehicle);
	}

}
