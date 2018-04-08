package edu.tum.cs.i1.eist;

import java.awt.Dimension;
import javax.swing.JToolBar;

import edu.tum.cs.i1.eist.car.UserCar;
import edu.tum.cs.i1.eist.instruments.*;

public class InstrumentPanel extends JToolBar {

	private static final long serialVersionUID = 1L;
	private JToolBar controlToolBar;
	
	private Body bodyView;
	private RotationsPerSecond rotationsPerSecond;
	private Speedometer speedometer;
	private SpeedController speedController;
	private GPS gps;
	private AnalogSpeedometerAdapter analogSpeedometerAdapter;
	
	public InstrumentPanel(UserCar userCar){
		super(JToolBar.VERTICAL);
		setFloatable(false);
		
		createInstruments(userCar);
		subscribeInstruments(userCar);
		addInstruments();
		
		controlToolBar = new JToolBar();
		controlToolBar.setFloatable(false);
		
		add(controlToolBar);
	}
	
	private void createInstruments(UserCar userCar) {
		rotationsPerSecond = new RotationsPerSecond(userCar);
		speedometer = new Speedometer(userCar);
		speedController = new SpeedController(userCar);
		bodyView = new Body(userCar);
		gps = new GPS(userCar);
		analogSpeedometerAdapter = new AnalogSpeedometerAdapter(userCar, new AnalogSpeedometer());
	}
	
	private void addInstruments() {
		add(rotationsPerSecond);
		add(speedometer);
		add(analogSpeedometerAdapter.getAnalogSpeedometer());
		add(speedController);
		add(gps);
		add(bodyView);
	}	
	
	private void subscribeInstruments(UserCar userCar) {
		userCar.subscribeInstrument(rotationsPerSecond);
		userCar.subscribeInstrument(speedometer);
		userCar.subscribeInstrument(speedController);
		userCar.subscribeInstrument(gps);
		userCar.subscribeInstrument(bodyView);
		userCar.subscribeInstrument(analogSpeedometerAdapter);
	}
	
	public Dimension getPreferredSize(){
		Dimension d = super.getPreferredSize();
		return new Dimension(300, d.height);
	}
	
	public Dimension getMinimumSize(){
		Dimension d = super.getMinimumSize();
		return new Dimension(300, d.height);
	}
	
	public Dimension getMaximumSize(){
		Dimension d = super.getMaximumSize();
		return new Dimension(300, d.height);
	}
}
