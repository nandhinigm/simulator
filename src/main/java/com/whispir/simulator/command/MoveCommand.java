package com.whispir.simulator.command;

import java.util.Map;

import org.apache.log4j.Logger;

import com.whispir.simulator.RobotPosition;
import com.whispir.simulator.Table;
import com.whispir.simulator.common.FacingDirection;
import com.whispir.simulator.common.ValidCommands;

/**
 * MOVE will move the toy robot one unit forward in the direction it is currently facing.
 */

public class MoveCommand implements Command {
	
	public static final String NAME = ValidCommands.MOVE.name();
	RobotPosition position;	
	Table table;
	Map<String, String> params;
	private static final Logger logger = Logger.getLogger(MoveCommand.class);
	
	public MoveCommand(Table table, RobotPosition position, Map<String, String> inputParameters) {
		this.position = position;
		this.table = table;
		this.params = inputParameters;
	}
	
	/* 
	 * (non-Javadoc)
	 * @see com.whispir.simulator.command.Command#execute(com.whispir.simulator.Table, com.whispir.simulator.RobotPosition, java.lang.Object)
	 * 
	 * If facing direction is East, nextPosition would be (x+1), y
	 * North = x, (y +1)
	 * West = (x-1), y
	 * South = x, (y-1)
	 */
	
	@Override
	public void execute() {
		FacingDirection direction = position.getDirection();
		if(direction != null && table.isValidMove(position)) {
			switch(direction) {
			case EAST:
				position.setX(position.getX() + 1);
				break;
			case NORTH:
				position.setY(position.getY() + 1);
				break;
			case WEST:
				position.setX(position.getX() - 1);
				break;
			case SOUTH:
				position.setY(position.getY() - 1);				
			}	
			logger.debug("Position : " + position.toString());
		}		
	}
}
