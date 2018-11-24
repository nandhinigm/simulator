package com.whispir.simulator.command;

import java.util.Map;

import com.whispir.simulator.RobotPosition;
import com.whispir.simulator.Table;
import com.whispir.simulator.common.ValidCommands;

public class CommandFactory {
	
	public static Command getCommand(String name, Table table, RobotPosition position, Map<String, String> inputParameters) {
		
		if(ValidCommands.LEFT.name().equals(name)) {
			return new LeftCommand(table, position, inputParameters);
		} else if(ValidCommands.RIGHT.name().equals(name)) {
			return new RightCommand(table, position, inputParameters);
		} else if(ValidCommands.PLACE.name().equals(name)) {
			return new PlaceCommand(table, position, inputParameters);
		} else if(ValidCommands.MOVE.name().equals(name)) {
			return new MoveCommand(table, position, inputParameters);
		} else if(ValidCommands.REPORT.name().equals(name)) {
			return new ReportCommand(table, position, inputParameters);
		}
		else
			return null;
	}
}
