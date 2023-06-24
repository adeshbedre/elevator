package com.flexcar.elevator;

import com.flexcar.elevator.controller.ElevatorController;
import com.flexcar.elevator.model.ElevatorDirectionButtonEnum;

public class Passenger {
	

	private int currentFloor;
	
	private String name;

	private Elevator calledElevator;
	
	

	@Override
	public String toString() {
		return "Passenger [currentFloor=" + currentFloor + ", name=" + name + ", calledElevator=" + calledElevator
				+ "]";
	}

	public Passenger(String name,int currentFloor) {
		super();
		this.name = name;
		this.currentFloor = currentFloor;
	}

	public void pickFloor(int pickedFloor) {

		if (calledElevator == null) {
			System.out.println("Please call elevator before picking floor");
			return;
		}
		// if currentElevator is null then throw Exception "not inside elevator"

		boolean elevatorFlag = calledElevator.pickFloor(pickedFloor);
		if (elevatorFlag) {
			calledElevator = null;
		}
		this.currentFloor = pickedFloor;
		// change currentFloor of passenger
		// change elevatorFloor
		// change currentelevator to null;

	}

	public void callElevator(ElevatorDirectionButtonEnum direction) {

		if (calledElevator != null) {
			System.out.println("Already inside elavator");
			return;
		}
		
		Elevator elevator = ElevatorController.callClosestElevator(this.currentFloor, direction);
		this.calledElevator = elevator;
		System.out.println("passenger is at floor "+currentFloor);
		System.out.println("The closest elevator called is "+elevator);
	}
}
