package com.nattguld.adb.actions.impl;

import com.nattguld.adb.actions.ADBAction;

/**
 * 
 * @author randqm
 *
 */

public class ToggleUSBTethering extends ADBAction {
	
	/**
	 * Whether to turn on or off.
	 */
	private final boolean on;
	
	
	/**
	 * Creates a new ADB action.
	 * 
	 * @param on Whether to turn on or off.
	 */
	public ToggleUSBTethering(boolean on) {
		this.on = on;
	}
	
	@Override
	protected String[] getCommands() {
		return new String[] {
				buildCommand("5.1.0")
		};
	}
	
	/**
	 * Builds the command for the given android version.
	 * 
	 * @param version The version.
	 * 
	 * @return The command.
	 */
	protected String buildCommand(String version) {
		switch (version) {
		case "4.4.4":
		case "5.1.0":
		case "6.0.1":
		case "7.0.0":
			return "adb shell su -c service call connectivity " + getIdForVersion(version) + " i32 " + (on ? 1 : 0);
			
		case "8.0":
		case "8.1":
		case "9.0":
			return "adb service call connectivity " + getIdForVersion(version) + " i32 " + (on ? 1 : 0) + " s16 text";
		}
		return "adb shell su -c service call connectivity " + getIdForVersion(version) + " i32 " + (on ? 1 : 0);
	}
	
	/**
	 * Retrieves the ID for a given android version.
	 * 
	 * @param version The android version.
	 * 
	 * @return The id.
	 */
	protected int getIdForVersion(String version) {
		switch (version) {
		case "4.4.4":
			return 34;
			
		case "5.1.0":
		case "6.0.1":
			return 30;
			
		case "7.0.0":
			return 33;
			
		case "8.0":
		case "8.1":
			return 34;
			
		case "9.0":
			return 33;
		}
		return 30;
	}

}
