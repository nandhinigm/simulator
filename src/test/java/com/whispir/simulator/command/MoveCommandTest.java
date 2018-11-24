package com.whispir.simulator.command;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

import com.whispir.simulator.RobotPosition;
import com.whispir.simulator.SquareTable;
import com.whispir.simulator.Table;
import com.whispir.simulator.common.CommonProperties;
import com.whispir.simulator.common.FacingDirection;

public class MoveCommandTest {
	
	RobotPosition position;	
	Table table;
	Map<String, String> params;
	MoveCommand moveCmd;
	int minX = 0;
	int minY = 0;
	int maxX = CommonProperties.X_UNITS;
	int maxY = CommonProperties.Y_UNITS;
	
	@Before
	public void setUp() {
		position = new RobotPosition();
		table = new SquareTable(maxX, maxY);
		params = new HashMap<String, String>();
		moveCmd = new MoveCommand(table, position, params);
	}
	
	@Test
	public void testExecute_BeforePlace_Ignore() {
		moveCmd.execute();
		assertEquals(position.getDirection(), null);
	}
	
	/*
	 * FacingDirection = WEST, Co-ordinates  = (0,0), (0,1), (0,2), (0,3), (0,4), (0,5)
	 *  Move should be ignored.  
	 */
	
	@Test
	public void testExecute_AfterPlace_West_Ignore() {
		
		position.setDirection(FacingDirection.WEST);
		IntStream.rangeClosed(minY, maxY).forEach( i  -> { position.setY(i);
		moveCmd.execute();
		assertEquals(position.getDirection(), FacingDirection.WEST);
		assertEquals(position.getX(), minX);
		assertEquals(position.getY(), i);
		}
		);
	}		
	
	/*
	 * FacingDirection = SOUTH, Co-ordinates  = (0,0), (1,0), (2,0), (3,0), (4,0), (5,0)
	 *  Move should be ignored
	 */
	
	@Test
	public void testExecute_AfterPlace_SOUTH_Ignore() {
		position.setDirection(FacingDirection.SOUTH);
		IntStream.rangeClosed(minX, maxX).forEach( i  -> { position.setX(i);
		moveCmd.execute();
		assertEquals(position.getDirection(), FacingDirection.SOUTH);
		assertEquals(position.getX(), i);
		assertEquals(position.getY(), minY);
		}
		);				
	}
	
	/*
	 * FacingDirection = EAST, Co-ordinates  = (5,0), (5,1), (5,2), (5,3), (5,4), (5,5)
	 * Move should be ignored  
	 */
	
	@Test
	public void testExecute_AfterPlace_East_Ignore() {
		
		position.setX(maxX);
		position.setDirection(FacingDirection.EAST);
		IntStream.rangeClosed(minY, maxY).forEach( i  -> { position.setY(i);
		moveCmd.execute();
		assertEquals(position.getDirection(), FacingDirection.EAST);
		assertEquals(position.getX(), maxX);
		assertEquals(position.getY(), i);
		}
		);			
	}
	
	/*
	 * FacingDirection = NORTH, Co-ordinates  = (0,5), (1,5), (2,5), (3,5), (4,5), (5,5)
	 *  Move should be ignored
	 */
	
	@Test
	public void testExecute_AfterPlace_NORTH_Ignore() {
		
		position.setY(maxY);
		position.setDirection(FacingDirection.NORTH);
		IntStream.rangeClosed(minX, maxX).forEach( i  -> { position.setX(i);
		moveCmd.execute();
		assertEquals(position.getDirection(), FacingDirection.NORTH);
		assertEquals(position.getX(), i);
		assertEquals(position.getY(), maxY);
		}
		);		
	}
	
	/*
	 * FacingDirection = NORTH. Valid Co-Ordinates 
	 * Move towards North(y+1)
	 */
	
	@Test
	public void testExecute_AfterPlace_NORTH() {
		position.setDirection(FacingDirection.NORTH);
		for(int i = minX; i <= maxX; i++) {
			for(int j = minY; j < maxY; j++) {
				position.setX(i);
				position.setY(j);
				moveCmd.execute();
				assertEquals(position.getDirection(), FacingDirection.NORTH);
				assertEquals(position.getX(), i);
				assertEquals(position.getY(), j+1);
			}
		}
	}
	
	/*
	 * FacingDirection = EAST. Valid Co-Ordinates
	 * Move towards East(x+1)
	 */
	
	@Test
	public void testExecute_AfterPlace_EAST() {
		position.setDirection(FacingDirection.EAST);
		for(int i = minX; i < maxX; i++) {
			for(int j = minY; j <= maxY; j++) {
				position.setX(i);
				position.setY(j);
				moveCmd.execute();
				assertEquals(position.getDirection(), FacingDirection.EAST);
				assertEquals(position.getX(), i+1);
				assertEquals(position.getY(), j);
			}
		}
	}	
	
	/*
	 * FacingDirection = SOUTH. Valid Co-Ordinates 
	 * Move towards South(y-1)
	 */
	
	@Test
	public void testExecute_AfterPlace_SOUTH() {
		position.setDirection(FacingDirection.SOUTH);
		for(int i = minX; i <= maxX; i++) {
			for(int j = minY + 1; j <= maxY; j++) {
				position.setX(i);
				position.setY(j);
				moveCmd.execute();
				assertEquals(position.getDirection(), FacingDirection.SOUTH);
				assertEquals(position.getX(), i);
				assertEquals(position.getY(), j-1);
			}
		}
	}
	
	/*
	 * FacingDirection = WEST. Valid Co-Ordinates
	 * Move towards West(x-1)
	 */
	
	@Test
	public void testExecute_AfterPlace_WEST() {
		position.setDirection(FacingDirection.WEST);
		for(int i = minX + 1; i <= maxX; i++) {
			for(int j = minY; j <= maxY; j++) {
				position.setX(i);
				position.setY(j);
				moveCmd.execute();
				assertEquals(position.getDirection(), FacingDirection.WEST);
				assertEquals(position.getX(), i-1);
				assertEquals(position.getY(), j);
			}
		}
	}	
}
