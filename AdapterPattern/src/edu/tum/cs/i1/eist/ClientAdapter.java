package edu.tum.cs.i1.eist;

public class ClientAdapter {

	public static void main(String[] args) {
		USCharger usCharger = new USCharger();
		PowerAdapter powerAdapter = new USPowerAdapter(usCharger);
		connectAdapterToWall(powerAdapter);
	}
	
	private static void connectAdapterToWall(PowerAdapter powerAdapter) {
		powerAdapter.getPower();
	}


}
