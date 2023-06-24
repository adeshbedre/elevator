package com.flexcar.elevator.runner;

import java.util.ArrayList;
import java.util.List;

import com.flexcar.elevator.Elevator;
import com.flexcar.elevator.Passenger;
import com.flexcar.elevator.model.ElevatorDirectionButtonEnum;
import com.flexcar.elevator.model.ElevatorStateEnum;

public class ElevatorRunner {

	public static List<Elevator> elevators = new ArrayList<>();
	public static List<Passenger> passengersList = new ArrayList<>();

	public static void main(String args[]) {
		elevators = initilizeElevators();
		passengersList = initializePassengers();
		printEleavatorAndPassengerInfo();

		Passenger passenger = passengersList.get(0);
		passenger.callElevator(ElevatorDirectionButtonEnum.UP);
		passenger.pickFloor(6);
		printEleavatorAndPassengerInfo();
		
		System.out.println("=======");
		passenger = passengersList.get(1);
		passenger.callElevator(ElevatorDirectionButtonEnum.DOWN);
		passenger.pickFloor(8);
		printEleavatorAndPassengerInfo();
		System.out.println("=======");
	}
	
	public static void printEleavatorAndPassengerInfo() {
		System.out.println();
		System.out.println();
		System.out.println("All the elevators are " + elevators);
		System.out.println();
		System.out.println();
		System.out.println("The passengersList is " + passengersList);
		System.out.println();
	}

	private static List<Passenger> initializePassengers() {
		int[] arr = { 1, 5 };
		List<Passenger> passengerList = new ArrayList<>();
		char ch = 'a';
		for (int currentFloor : arr) {
			passengerList.add(new Passenger(ch + "", currentFloor));
			ch++;
		}
		return passengerList;
	}

	private static List<Elevator> initilizeElevators() {
		int[] arr = { 7, 2, 4, 0 };
		List<Elevator> elevatorList = new ArrayList<>();
		int count = 0;
//		for (int currentFloor : arr) {
//			elevatorList.add(new Elevator(ElevatorStateEnum.STOP, currentFloor, count));
//			count++;
//		}
		elevatorList.add(new Elevator(ElevatorStateEnum.STOP, arr[count], count));
		count++;
		elevatorList.add(new Elevator(ElevatorStateEnum.UP, arr[count], count));
		count++;
		elevatorList.add(new Elevator(ElevatorStateEnum.DOWN, arr[count], count));
		count++;
		elevatorList.add(new Elevator(ElevatorStateEnum.STOP, arr[count], count));
		count++;
		return elevatorList;
	}

	public List<Elevator> getElevators() {
		return elevators;
	}

}
