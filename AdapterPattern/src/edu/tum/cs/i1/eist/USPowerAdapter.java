package edu.tum.cs.i1.eist;

public class USPowerAdapter extends PowerAdapter {
	private USCharger adaptee;
	
	public USPowerAdapter(USCharger adaptee){
		this.adaptee = adaptee;
	}
	
	@Override
	public void getPower() {
		adaptee.provide120Volt();
	}
}
