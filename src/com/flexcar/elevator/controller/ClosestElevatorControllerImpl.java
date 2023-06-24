package com.flexcar.elevator.controller;

import java.util.ArrayList;
import java.util.List;

import com.flexcar.elevator.Elevator;
import com.flexcar.elevator.model.ElevatorDirectionButtonEnum;
import com.flexcar.elevator.model.ElevatorStateEnum;
import com.flexcar.elevator.runner.ElevatorRunner;

public class ClosestElevatorControllerImpl implements ElevatorController {

	@Override
	public Elevator callClosestElevator(int passengerFloor, ElevatorDirectionButtonEnum passengerDirection) {
		List<Elevator> elevators = ElevatorRunner.elevators;
		// pick the one moving in the same direction or stopped
		// among them pick the ones that are nearest to that floow
		List<Elevator> closeElevatorList = new ArrayList<>();
		for (Elevator elevator : elevators) {
			if ((elevator.getState().name().equals(passengerDirection.name())
					|| elevator.getState().equals(ElevatorStateEnum.STOP))) {
				closeElevatorList.add(elevator);
			}
		}

		if (closeElevatorList.isEmpty()) {
			// pick the closest
			closeElevatorList = elevators;
		}

		Elevator nearestElevator = null;
		for (Elevator elevator : closeElevatorList) {
			if (nearestElevator == null || Math.abs(passengerFloor - elevator.getCurrentFloor()) < Math
					.abs(passengerFloor - nearestElevator.getCurrentFloor())) {
				nearestElevator = elevator;
			}
		}

		return nearestElevator;
	}
}
