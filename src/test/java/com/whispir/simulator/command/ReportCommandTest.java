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

public class ReportCommandTest {
	
	RobotPosition position;	
	Table table;
	Map<String, String> params;
	ReportCommand reportCmd;
	int minX = 0;
	int minY = 0;
	int maxX = CommonProperties.X_UNITS;
	int maxY = CommonProperties.Y_UNITS;
	
	@Before
	public void setUp() {
		position = new RobotPosition();
		table = new SquareTable(maxX, maxY);
		params = new HashMap<String, String>();
		reportCmd = new ReportCommand(table, position, params);
	}
	
	@Test
	public void testExecute_BeforePlace_Ignore() {
		reportCmd.execute();
		assertEquals(position.getDirection(), null);		
	}
	
	@Test
	public void testExecute_AfterPlace_West() {
		position.setX(maxX);
		position.setX(maxY);
		position.setDirection(FacingDirection.WEST);
		reportCmd.execute();
		assertEquals(position.toString(), position.getX() + "," + position.getY() + "," + position.getDirection().name());
	}
	

}
