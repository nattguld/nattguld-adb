package com.nattguld.adb.actions;

import java.util.Objects;

import com.nattguld.adb.Dispatcher;

/**
 * 
 * @author randqm
 *
 */

public abstract class ADBAction {
	
	
	/**
	 * Executes the commands.
	 * 
	 * @return The commands.
	 */
	public boolean execute() {
		if (Objects.isNull(getCommands()) || getCommands().length <= 0) {
			System.err.println("No commands provided in " + getClass().getSimpleName());
			return false;
		}
		for (String cmd : getCommands()) {
			if (!Dispatcher.sendCommand(cmd)) {
				System.err.println("Failed to execute " + cmd);
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Retrieves the commands to execute.
	 * 
	 * @return The commands.
	 */
	protected abstract String[] getCommands();

}
