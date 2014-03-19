package com.ericsson.design.elevator;

public enum ElevatorDirection 
{
	UP, DOWN, STILL;

//	public int getNextFloor(int currentFloor) 
//	{
//		if(this.equals(UP))
//		{
//			return currentFloor + 1;
//		}
//		else if(this.equals(DOWN))
//		{
//			return currentFloor - 1;
//		}
//		
//		return currentFloor;
//	}
//
//	public ElevatorDirection reverse() 
//	{
//		if(this.equals(UP))
//		{
//			return DOWN;
//		}
//		else if(this.equals(DOWN))
//		{
//			return UP;
//		}
//		
//		return this;
//	}
//
//	public ElevatorFloorRequest getFloorRequest() 
//	{
//		if(this.equals(UP))
//		{
//			return ElevatorFloorRequest.UP;
//		}
//		else if(this.equals(DOWN))
//		{
//			return ElevatorFloorRequest.DOWN;
//		}
//		
//		return ElevatorFloorRequest.OFF;
//	}
//
//	public int getLastFloor(int floor, int lastFloor) 
//	{
//		if ((this.equals(UP) && floor > lastFloor)
//				|| (this.equals(DOWN) && floor < lastFloor)) 
//		{
//			return floor;
//		}
//
//		return lastFloor;
//	}
//
//	public boolean shouldMove(int currentFloor, int lastFloor) 
//	{
//		if ((this.equals(UP) && lastFloor > currentFloor)
//				|| (this.equals(DOWN) && lastFloor < currentFloor)) 
//		{
//			return true;
//		}
//
//		return false;
//	}
}
