package com.whispir.simulator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.whispir.simulator.common.FacingDirection;

/**
 * Unit test for Toy Robot Simulator.
 */
public class SimulatorTest {
	
	Simulator simulator;
	
	@Before
	public void setUp() {		
		simulator = new Simulator();
	}
	
	@Test
	public void testProcessCommand_Invalid() {
		simulator.processCommand("TEST");
		assertEquals(simulator.position.getDirection(), null);
		
		simulator.processCommand("REPORT");
		assertEquals(simulator.position.getDirection(), null);
		
		simulator.processCommand("PLACE");
		assertEquals(simulator.position.getDirection(), null);
		
		simulator.processCommand("MOVE");
		assertEquals(simulator.position.getDirection(), null);
		
		simulator.processCommand("LEFT");
		assertEquals(simulator.position.getDirection(), null);
		
		simulator.processCommand("RIGHT");
		assertEquals(simulator.position.getDirection(), null);
		
		simulator.processCommand("PLACE 0,0");
		assertEquals(simulator.position.getDirection(), null);
		
		simulator.processCommand("PLACE 0,0,TEST");
		assertEquals(simulator.position.getDirection(), null);
		
		simulator.processCommand("PLACE -1,-1,NORTH");
		assertEquals(simulator.position.getDirection(), null);
		
		simulator.processCommand("PLACE 6,6,NORTH");
		assertEquals(simulator.position.getDirection(), null);
	}
	
	@Test
	public void testProcessCommand_valid() {
		
		simulator.processCommand("PLACE 0,0,NORTH");		
		simulator.processCommand("MOVE");
		simulator.processCommand("REPORT");
		assertEquals(simulator.position.getDirection(), FacingDirection.NORTH);
		assertEquals(simulator.position.getX(), 0);
		assertEquals(simulator.position.getY(), 1);
		
		simulator.processCommand("PLACE 0,0,NORTH");		
		simulator.processCommand("LEFT");
		simulator.processCommand("REPORT");
		assertEquals(simulator.position.getDirection(), FacingDirection.WEST);
		assertEquals(simulator.position.getX(), 0);
		assertEquals(simulator.position.getY(), 0);
		
		simulator.processCommand("PLACE 1,2,EAST");		
		simulator.processCommand("MOVE");
		simulator.processCommand("MOVE");
		simulator.processCommand("LEFT");
		simulator.processCommand("MOVE");
		simulator.processCommand("REPORT");
		assertEquals(simulator.position.getDirection(), FacingDirection.NORTH);
		assertEquals(simulator.position.getX(), 3);
		assertEquals(simulator.position.getY(), 3);
		
		simulator.processCommand("PLACE 5,5,WEST");		
		simulator.processCommand("RIGHT");
		simulator.processCommand("REPORT");
		assertEquals(simulator.position.getDirection(), FacingDirection.NORTH);
		assertEquals(simulator.position.getX(), 5);
		assertEquals(simulator.position.getY(), 5);
		
		simulator.processCommand("PLACE 3,4,SOUTH");		
		simulator.processCommand("MOVE");
		simulator.processCommand("MOVE");
		simulator.processCommand("RIGHT");
		simulator.processCommand("MOVE");
		simulator.processCommand("REPORT");
		assertEquals(simulator.position.getDirection(), FacingDirection.WEST);
		assertEquals(simulator.position.getX(), 2);
		assertEquals(simulator.position.getY(), 2);		
	}		
}
