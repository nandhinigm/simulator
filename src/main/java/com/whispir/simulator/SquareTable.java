package com.whispir.simulator;

import com.whispir.simulator.common.FacingDirection;

public class SquareTable implements Table {

	public int x, y;

	public SquareTable(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/*
	 * (non-Javadoc)
	 * @see com.whispir.simulator.Table#isValidMove(com.whispir.simulator.RobotPosition)
	 * 
	 * Positions where next move should be ignored are, 
	 * North = (0,5), (1,5), (2,5), (3,5), (4,5), (5,5)
	 * South = (0,0), (1,0), (2,0), (3,0), (4,0), (5,0)
	 * West  = (0,0), (0,1), (0,2), (0,3), (0,4), (0,5)
	 * East  = (5,0), (5,1), (5,2), (5,3), (5,4), (5,5)
	 * 
	 */
	
	public boolean isValidMove(RobotPosition position) {

		FacingDirection direction = position.getDirection();
		int xPos = position.getX();
		int yPos = position.getY();

		switch(direction) {
		case NORTH:
			return (yPos == y) ? false : true;				
		case WEST:
			return (xPos == 0) ? false : true;			
		case SOUTH:
			return (yPos == 0) ? false : true;
		case EAST:
			return (xPos == x) ? false : true;
		default:
			return true;
		}
	}

	public boolean isValidPlace(int xPos, int yPos) {				
		return (xPos > x || yPos > y || xPos < 0 || yPos < 0) ? false : true;		
	}
}
