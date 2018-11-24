package com.whispir.simulator;

public interface Table {
	
	public boolean isValidMove(RobotPosition position);
	public boolean isValidPlace(int x, int y);
}
