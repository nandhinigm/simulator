package com.whispir.simulator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.whispir.simulator.command.CommandFactory;
import com.whispir.simulator.common.InvalidDataException;
import com.whispir.simulator.common.CommonProperties;
import com.whispir.simulator.common.ValidCommands;

/**
 * Toy Robot Simulator
 * The application is a simulation of a toy robot moving on a square tabletop, of dimensions 5 units x 5 units.
 * There are no obstructions on the table surface.
 * The robot is free to roam around the surface of the table, but is prevented from falling to destruction
 * Any movement that would result in the robot falling from the table is prevented, 
 * however further valid movement commands are still allowed.
 *
 */

public class Simulator {

	RobotPosition position;	
	Table table;

	public Simulator() {

		position = new RobotPosition();	
		table = new SquareTable(CommonProperties.X_UNITS, CommonProperties.Y_UNITS);
	}

	public void processCommand(String input) {

		Map<String, String> inputParams = new HashMap<String, String>();
		String[] placeCommandAndValues = input.split(CommonProperties.SPACE_DELIMITER);
		String command = placeCommandAndValues[0];
		try {
			if(Arrays.stream(ValidCommands.values()).anyMatch((t) -> t.name().equals(command))) {	
				if(input.startsWith(ValidCommands.PLACE.name())) {					
					if(placeCommandAndValues.length == 2) {
						String[] params = placeCommandAndValues[1].split(CommonProperties.COMMA_DELIMITER);
						if(params.length == 3) {
							inputParams.put(CommonProperties.COORDINATE_X, params[0]);
							inputParams.put(CommonProperties.COORDINATE_Y, params[1]);
							inputParams.put(CommonProperties.DIRECTION, params[2]);
							simulate(command, inputParams);
						}					
						else {
							System.out.println(CommonProperties.INPUTFORMAT_MSG);
						}
					} else {
						System.out.println(CommonProperties.INPUTFORMAT_MSG);
					}
				} else if(placeCommandAndValues.length == 1){
					simulate(input, inputParams);
				} else {
					System.out.println(CommonProperties.INPUTFORMAT_MSG);
				}
			} else {
				System.out.println(CommonProperties.INPUTFORMAT_MSG);
			}
		} catch(InvalidDataException ie) {
			System.out.println(ie.getMessage());
		}
	}

	private void simulate(String command, Map<String, String> inputParams) throws InvalidDataException {
		CommandFactory.getCommand(command, table, position, inputParams).execute();
	}

	public static void main( String[] args ) {

		Simulator simulator = new Simulator();	
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				System.out.println("Exiting..!");				
			}
		});	
		Scanner scanner;		
		while(true) {
			scanner = new Scanner(System.in);
			if(scanner.hasNextLine()) {
				String input = scanner.nextLine();			
				if(CommonProperties.QUIT.equals(input)) {
					scanner.close();
					System.exit(0);								
				} else if(input == null) {
					System.out.println(CommonProperties.INPUTFORMAT_MSG);				
				} else {
					simulator.processCommand(input);											
				} 
			}
		}			
	}
}


