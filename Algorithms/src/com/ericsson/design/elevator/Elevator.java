package com.ericsson.design.elevator;




public class Elevator
{
	//private LinkedList<Floor> floorRequests;
	private ElevatorFloorRequest[] floorRequests;
	private ElevatorDirection elevatorDirection;
	private int currentFloor;
	private boolean isRunning;
	//private int numRequests;
	private int numRequestsForward;
	private int numRequestsBackward;
	
	public void addFloorRequest(int floor)
	{
		if(floorRequests[floor].equals(ElevatorFloorRequest.OFF))
		{
			updateRequestCounts(floor);
			floorRequests[floor] = ElevatorFloorRequest.ON;
			startIfFirstRequest(floor);
		}
	}
	
	public void removeFloorRequest(int floor)
	{
		if(floorRequests[floor].equals(ElevatorFloorRequest.ON))
		{
			numRequestsForward--;
			floorRequests[floor] = ElevatorFloorRequest.OFF;
			stopIfLastRequest();
		}
	}
	
	private void updateRequestCounts(int floor) 
	{
		if(elevatorDirection.equals(ElevatorDirection.UP))
		{
			if(floor >= currentFloor)
			{
				numRequestsForward++;
			}
			else
			{
				numRequestsBackward++;
			}
		}
		else if(elevatorDirection.equals(ElevatorDirection.DOWN))
		{
			if(floor > currentFloor)
			{
				numRequestsBackward++;
			}
			else
			{
				numRequestsForward++;
			}
		}
	}
	
	private void startIfFirstRequest(int floor)
	{
		if(!isRunning)
		{
			isRunning = true;
			
			// Setting initial direction
			if(floor > currentFloor)
			{
				elevatorDirection = ElevatorDirection.UP;
			}
			else if(floor < currentFloor)
			{
				elevatorDirection = ElevatorDirection.DOWN;
			}
			else 
			{
				removeFloorRequest(currentFloor);
				open();
				return;
			}
			
			run(floor);
		}
	}

	private void stopIfLastRequest()
	{
		if((numRequestsForward + numRequestsBackward) == 0)
		{
			isRunning = false;
			elevatorDirection = ElevatorDirection.STILL;
		}
	}
	
	private void run(int floor)
	{	
		while(isRunning)
		{
			moveToNextFloorIfRequired();
			if(floorRequests[currentFloor].equals(ElevatorFloorRequest.ON))
			{
				removeFloorRequest(currentFloor);
				open();
			}
		}
	}

	private void moveToNextFloorIfRequired() 
	{
		try 
		{
			if(numRequestsForward > 0)
			{
				Thread.sleep(ElevatorSystem.ELEVATOR_TIME_BETWEEN_FLOORS);
			}
			else if(numRequestsBackward > 0)
			{
				// Reverse elevator direction
				if(elevatorDirection.equals(ElevatorDirection.UP))
				{
					elevatorDirection = ElevatorDirection.DOWN;
				}
				else
				{
					elevatorDirection = ElevatorDirection.UP;
				}
				
				int temp = numRequestsForward;
				numRequestsForward = numRequestsBackward;
				numRequestsBackward = temp;
			}

		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	private void open() 
	{
		try 
		{
			Thread.sleep(ElevatorSystem.FLOOR_WAIT_TIME);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}

	public boolean isRunning() 
	{
		return isRunning;
	}

	public int getCurrentFloor() 
	{
		return currentFloor;
	}

	public ElevatorDirection getDirection() 
	{
		return elevatorDirection;
	}

	public void addFloorRequest(ElevatorSystem elevatorSystem, int floor) 
	{
		addFloorRequest(floor);
		
	}
	
}
