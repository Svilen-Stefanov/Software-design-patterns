package edu.tum.cs.i1.eist.instruments;

import javax.swing.JPanel;

import edu.tum.cs.i1.eist.car.UserCar;

public abstract class Instrument extends JPanel {

	private static final long serialVersionUID = 1L;
	
	protected UserCar userCar;
	
	public Instrument(UserCar userCar) {
		this.userCar = userCar;
	}
	
	public abstract void updateInstrument();
}
