package com.whispir.simulator.command;

import java.util.Map;

import com.whispir.simulator.RobotPosition;
import com.whispir.simulator.Table;
import com.whispir.simulator.common.FacingDirection;
import com.whispir.simulator.common.ValidCommands;

public class RightCommand implements Command {

	public static final String NAME = ValidCommands.RIGHT.name();
	RobotPosition position;	
	Table table;
	Map<String, String> params;
	
	public RightCommand(Table table, RobotPosition position, Map<String, String> inputParameters) {
		this.position = position;
		this.table = table;
		this.params = inputParameters;
	}
	
	/*
	 * RIGHT rotate the robot 90 degrees in the specified direction without
	 *	changing the position of the robot.
	 * 
	 */
	
	@Override
	public void execute() {
		if(position.getDirection() != null) {
			position.setDirection(changeDirection(position.getDirection()));
		}	
	}    
	
	private FacingDirection changeDirection(FacingDirection direction) {
		switch(direction) {
		case NORTH:
			return FacingDirection.EAST;			
		case WEST:
			return FacingDirection.NORTH;			
		case SOUTH:
			return FacingDirection.WEST;
		case EAST:
			return FacingDirection.SOUTH;
		default:
			return null;			
		}
	}
}
