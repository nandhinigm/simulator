package com.whispir.simulator.command;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.whispir.simulator.RobotPosition;
import com.whispir.simulator.SquareTable;
import com.whispir.simulator.Table;
import com.whispir.simulator.common.FacingDirection;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

public class LeftCommandTest {
	
	RobotPosition position;	
	Table table;
	Map<String, String> params;
	LeftCommand leftCmd;
	
	@Before
	public void setUp() {
		position = new RobotPosition();
		table = new SquareTable(5, 5);
		params = new HashMap<String, String>();
		leftCmd = new LeftCommand(table, position, params);
	}
	
	@Test
	public void testExecute_BeforePlace_Ignore() {
		leftCmd.execute();
		assertEquals(position.getDirection(), null);
	}
	
	@Test
	public void testExecute_AfterPlace_West() {
		position.setDirection(FacingDirection.WEST);
		leftCmd.execute();
		assertEquals(position.getDirection(), FacingDirection.SOUTH);
	}
	
	@Test
	public void testExecute_AfterPlace_North() {
		position.setDirection(FacingDirection.NORTH);
		leftCmd.execute();
		assertEquals(position.getDirection(), FacingDirection.WEST);
	}
	
	@Test
	public void testExecute_AfterPlace_South() {
		position.setDirection(FacingDirection.SOUTH);
		leftCmd.execute();
		assertEquals(position.getDirection(), FacingDirection.EAST);
	}
	
	@Test
	public void testExecute_AfterPlace_East() {
		position.setDirection(FacingDirection.EAST);
		leftCmd.execute();
		assertEquals(position.getDirection(), FacingDirection.NORTH);
	}

	@After
	public void tearDown() {
		
	}
}
