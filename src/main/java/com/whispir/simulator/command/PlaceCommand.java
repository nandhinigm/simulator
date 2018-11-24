package com.whispir.simulator.command;

import java.util.Arrays;
import java.util.Map;

import com.whispir.simulator.RobotPosition;
import com.whispir.simulator.Table;
import com.whispir.simulator.common.CommonProperties;
import com.whispir.simulator.common.FacingDirection;
import com.whispir.simulator.common.InvalidDataException;
import com.whispir.simulator.common.ValidCommands;

public class PlaceCommand implements Command {

	public static final String NAME = ValidCommands.PLACE.name();
	RobotPosition position;	
	Table table;
	Map<String, String> params;
	
	public PlaceCommand(Table table, RobotPosition position, Map<String, String> inputParameters) {
		this.position = position;
		this.table = table;
		this.params = inputParameters;
	}
	
	@Override
	public void execute() throws InvalidDataException {
				
		try {				
			int x = Integer.parseInt(params.get(CommonProperties.COORDINATE_X));
			int y = Integer.parseInt(params.get(CommonProperties.COORDINATE_Y));
			String direction = params.get(CommonProperties.DIRECTION).toUpperCase();
			if(table.isValidPlace(x, y) && 
					Arrays.stream(FacingDirection.values()).anyMatch((t) -> t.name().equals(direction))) {
				position.setX(x);
				position.setY(y);
				position.setDirection(FacingDirection.valueOf(direction));	
			}
		} catch(NumberFormatException ne) {
			throw new InvalidDataException(CommonProperties.INVALIDDATA_MSG);
		}
	}
}
