package edu.tum.cs.i1.eist.vehicle;

import edu.tum.cs.i1.eist.vehicle.component.*;

public class Vehicle {
	
	Brake brake;
	Engine engine;
	Ignition ignition;
	Radio radio;
	Cockpit cockpit;
	
	public Vehicle() {
		super();
		this.brake = new Brake();
		this.engine = new Engine();
		this.ignition = new Ignition();
		this.radio = new Radio();
		this.cockpit = new Cockpit();
	}
	
}
