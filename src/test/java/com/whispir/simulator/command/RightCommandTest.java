package com.whispir.simulator.command;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.whispir.simulator.RobotPosition;
import com.whispir.simulator.SquareTable;
import com.whispir.simulator.Table;
import com.whispir.simulator.common.FacingDirection;

public class RightCommandTest {
	
	RobotPosition position;	
	Table table;
	Map<String, String> params;
	RightCommand rightCmd;
	
	@Before
	public void setUp() {
		position = new RobotPosition();
		table = new SquareTable(4, 4);
		params = new HashMap<String, String>();
		rightCmd = new RightCommand(table, position, params);
	}
	
	@Test
	public void testExecute_BeforePlace_Ignore() {
		rightCmd.execute();
		assertEquals(position.getDirection(), null);
	}
	
	@Test
	public void testExecute_AfterPlace_West() {
		position.setDirection(FacingDirection.WEST);
		rightCmd.execute();
		assertEquals(position.getDirection(), FacingDirection.NORTH);
	}
	
	@Test
	public void testExecute_AfterPlace_North() {
		position.setDirection(FacingDirection.NORTH);
		rightCmd.execute();
		assertEquals(position.getDirection(), FacingDirection.EAST);
	}
	
	@Test
	public void testExecute_AfterPlace_South() {
		position.setDirection(FacingDirection.SOUTH);
		rightCmd.execute();
		assertEquals(position.getDirection(), FacingDirection.WEST);
	}
	
	@Test
	public void testExecute_AfterPlace_East() {
		position.setDirection(FacingDirection.EAST);
		rightCmd.execute();
		assertEquals(position.getDirection(), FacingDirection.SOUTH);
	}

	@After
	public void tearDown() {
		
	}

}
