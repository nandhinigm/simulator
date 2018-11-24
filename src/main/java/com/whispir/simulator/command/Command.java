package com.whispir.simulator.command;

import com.whispir.simulator.common.InvalidDataException;

public interface Command {

	public void execute() throws InvalidDataException;
}
