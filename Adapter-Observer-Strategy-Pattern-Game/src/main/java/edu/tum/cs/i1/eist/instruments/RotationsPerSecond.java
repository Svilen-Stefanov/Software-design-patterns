package edu.tum.cs.i1.eist.instruments;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import edu.tum.cs.i1.eist.car.UserCar;


public class RotationsPerSecond extends Instrument  {

	private static final long serialVersionUID = 1L;
	private JLabel theLabel = new JLabel("", JLabel.LEFT);

	
	public RotationsPerSecond(UserCar userCar) {
		super(userCar);
		setLayout(new BorderLayout());
		add(theLabel, BorderLayout.CENTER);
		theLabel.setText(getSpeedText(userCar.getSpeed()));
	}

	public void updateInstrument() {
		String newText = getSpeedText(userCar.getSpeed());
		if(!newText.equals(theLabel.getText())){
			theLabel.setText(newText);
		}
	}
	
	protected String getSpeedText(float rotationsPerSecond){
		return "Umdrehungen pro Sekunde: "+rotationsPerSecond*1000;
	}
}
