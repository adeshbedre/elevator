package com.flexcar.elevator.controller;

import com.flexcar.elevator.model.Constants;

public class ElevatorControllerFactory {

	public static ElevatorController fetchElevatorAlgo(String algo) {
		
		if(Constants.ALGO_CLOSEST_ELEVATOR.equals(algo)) {
			return new ClosestElevatorControllerImpl();
		}
		return null;
	}

	
	
}
