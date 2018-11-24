package com.whispir.simulator.command;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.whispir.simulator.RobotPosition;
import com.whispir.simulator.SquareTable;
import com.whispir.simulator.Table;
import com.whispir.simulator.common.CommonProperties;
import com.whispir.simulator.common.FacingDirection;
import com.whispir.simulator.common.InvalidDataException;

public class PlaceCommandTest {
	
	RobotPosition position;	
	Table table;
	Map<String, String> params;
	PlaceCommand placeCmd;
	int minX = 0;
	int minY = 0;
	int maxX = CommonProperties.X_UNITS;
	int maxY = CommonProperties.Y_UNITS;
	
	@Before
	public void setUp() {
		position = new RobotPosition();
		table = new SquareTable(maxX, maxY);
		params = new HashMap<String, String>();
		placeCmd = new PlaceCommand(table, position, params);
	}
	
	@Test(expected = InvalidDataException.class)
	public void testExecute_InValidPlace_Ignore() throws InvalidDataException {
		placeCmd.execute();	
		
		params.put(CommonProperties.COORDINATE_X, String.valueOf((minX -1)));
		params.put(CommonProperties.COORDINATE_Y, String.valueOf((minY)));
		placeCmd.execute();
		
		params.put(CommonProperties.COORDINATE_X, String.valueOf((minX)));
		params.put(CommonProperties.COORDINATE_Y, String.valueOf((minY-1)));
		placeCmd.execute();
		
		params.put(CommonProperties.COORDINATE_X, String.valueOf((minX-1)));
		params.put(CommonProperties.COORDINATE_Y, String.valueOf((minY-1)));
		placeCmd.execute();		
		
		params.put(CommonProperties.COORDINATE_X, String.valueOf((maxX+1)));
		params.put(CommonProperties.COORDINATE_Y, String.valueOf((maxY)));
		placeCmd.execute();
		
		params.put(CommonProperties.COORDINATE_X, String.valueOf((maxX)));
		params.put(CommonProperties.COORDINATE_Y, String.valueOf((maxY+1)));
		placeCmd.execute();
		
		params.put(CommonProperties.COORDINATE_X, String.valueOf((maxX+1)));
		params.put(CommonProperties.COORDINATE_Y, String.valueOf((maxY+1)));
		placeCmd.execute();
	}
	
	public void testExecute_ValidPlace() throws InvalidDataException {
		
		for(int i = minX; i <= maxX; i++) {
			for(int j = minY; j <= maxY; j++) {
				params.put(CommonProperties.COORDINATE_X, String.valueOf(i));
				params.put(CommonProperties.COORDINATE_Y, String.valueOf(j));
				params.put(CommonProperties.DIRECTION, FacingDirection.EAST.name());
				placeCmd.execute();
				assertEquals(position.getDirection(), FacingDirection.EAST);
				assertEquals(position.getX(), i);
				assertEquals(position.getY(), j);
			}
		}
	}
}
