package com.flexcar.elevator;

import com.flexcar.elevator.model.ElevatorStateEnum;

public class Elevator {

	private ElevatorStateEnum state;// up,down,stop

	private int currentFloor;

	private int elevatorNo;

	public ElevatorStateEnum getState() {
		return state;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public Elevator(ElevatorStateEnum state, int currentFloor, int elevatorNo) {
		super();
		this.state = state;
		this.currentFloor = currentFloor;
		this.elevatorNo = elevatorNo;
	}

	@Override
	public String toString() {
		return "Elevator [state=" + state + ", currentFloor=" + currentFloor + ", elevatorNo=" + elevatorNo + "]";
	}

	public int getElevatorNo() {
		return elevatorNo;
	}

	public boolean pickFloor(int pickedFloor) {

		// if currentElevator is null then throw Exception "not inside elevator"

		if (pickedFloor == currentFloor) {
			System.out.println("Already at floor " + pickedFloor);
			return false;
		}

		this.currentFloor = pickedFloor;
		return true;
	}

}
