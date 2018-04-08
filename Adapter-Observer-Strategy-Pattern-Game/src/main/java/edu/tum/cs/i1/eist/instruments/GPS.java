package edu.tum.cs.i1.eist.instruments;

import java.awt.BorderLayout;
import java.awt.Point;

import javax.swing.JLabel;

import edu.tum.cs.i1.eist.car.UserCar;

public class GPS extends Instrument {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel positionLabel = new JLabel();
	
	public GPS(UserCar userCar){
		super(userCar);
		setLayout(new BorderLayout());
		add(positionLabel, BorderLayout.CENTER);
		positionLabel.setText(getPositionText(userCar.getPosition()));
	}
	
	public void updateInstrument() {
		String newText = getPositionText(userCar.getPosition());
		if(!newText.equals(positionLabel.getText())){
			positionLabel.setText(newText);
		}
	}
	
	private String getPositionText(Point position){
		String x,y;
		if(position.x < 10){
			x = "000"+position.x;
		}else if(position.x < 100){
			x = "00"+position.x;
		}else if(position.x < 1000){
			x = "0"+position.x;
		}else{
			x = ""+position.x;
		}
		
		if(position.y < 10){
			y = "000"+position.y;
		}else if(position.y < 100){
			y = "00"+position.y;
		}else if(position.y < 1000){
			y = "0"+position.y;
		}else{
			y = ""+position.y;
		}
		
		return "GPS Koordinaten: "+x+" | "+y;
	}
}
