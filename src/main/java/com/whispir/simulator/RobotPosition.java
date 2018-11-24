package com.whispir.simulator;

import com.whispir.simulator.common.FacingDirection;

public class RobotPosition {
	
	int x;
	int y;
	FacingDirection direction;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public FacingDirection getDirection() {
		return direction;
	}
	public void setDirection(FacingDirection direction) {
		this.direction = direction;
	}
	
	@Override
	public String toString() {		
		return x + "," + y + "," + direction.name();
	}
}
