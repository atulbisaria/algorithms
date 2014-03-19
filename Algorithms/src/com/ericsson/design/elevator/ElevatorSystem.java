package com.ericsson.design.elevator;

import java.util.List;

public class ElevatorSystem 
{	
	public static int MAX_FLOORS = 10;
	public static int ELEVATOR_TIME_BETWEEN_FLOORS = 1000;
	public static int FLOOR_WAIT_TIME = 1000;
	
	private List<Elevator> elevators;
	private ElevatorFloorRequest[] upFloorRequests;
	private ElevatorFloorRequest[] downFloorRequests;
	
	public void addUpFloorRequest(int floor)
	{
		this.upFloorRequests[floor] = ElevatorFloorRequest.ON;
		
		for (Elevator elevator : elevators) 
		{
			if(elevator.getDirection().equals(ElevatorDirection.UP) && floor > elevator.getCurrentFloor())
			{
				elevator.addFloorRequest(this, floor);
			}
		}
		//requestIdleElevator(floor);
	}
	
	public void addDownFloorRequest(int floor)
	{
		this.downFloorRequests[floor] = ElevatorFloorRequest.ON;
		//requestIdleElevator(floor);
	}
	
	public void removeUpFloorRequest(int floor)
	{
		this.upFloorRequests[floor] = ElevatorFloorRequest.OFF;
	}
	
	public void removeDownFloorRequest(int floor)
	{
		this.downFloorRequests[floor] = ElevatorFloorRequest.OFF;
	}
	
	private void requestIdleElevator(int floor) 
	{
		int minDistance = MAX_FLOORS + 1;
		Elevator selectedElevator = null;
		for (Elevator elevator : elevators) 
		{
			if(!elevator.isRunning())
			{
				int distanceFromRequestedFloor = Math.abs((floor - elevator.getCurrentFloor()));
				if(distanceFromRequestedFloor < minDistance)
				{
					minDistance = distanceFromRequestedFloor;
					selectedElevator = elevator;
				}
			}
		}
		
		if(selectedElevator != null)
		{
			selectedElevator.addFloorRequest(floor);
		}
	}
}
