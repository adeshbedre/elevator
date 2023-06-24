package com.flexcar.elevator.controller;

import com.flexcar.elevator.Elevator;
import com.flexcar.elevator.model.ElevatorDirectionButtonEnum;

public interface ElevatorController {

	Elevator callClosestElevator(int passengerFloor, ElevatorDirectionButtonEnum passengerDirection);
	

}
