package com.thoughtworks.rover.commands;

import com.thoughtworks.rover.MarsRover;

public interface ICommand {

	void execute(final MarsRover rover);

}
