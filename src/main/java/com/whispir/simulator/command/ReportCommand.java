package com.whispir.simulator.command;

import java.util.Map;

import com.whispir.simulator.RobotPosition;
import com.whispir.simulator.Table;
import com.whispir.simulator.common.ValidCommands;

/**
 * REPORT will announce the X, Y and F of the robot.
 */
public class ReportCommand implements Command {
	
	public static final String NAME = ValidCommands.REPORT.name();
	RobotPosition position;	
	Table table;
	Map<String, String> params;
	
	public ReportCommand(Table table, RobotPosition position, Map<String, String> inputParameters) {
		this.position = position;
		this.table = table;
		this.params = inputParameters;
	}
	
	@Override
	public void execute() {
		if(position.getDirection() != null) {
			System.out.println("OUTPUT:" + position.toString());
		}
	}
}
