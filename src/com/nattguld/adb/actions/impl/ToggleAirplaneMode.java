package com.nattguld.adb.actions.impl;

import com.nattguld.adb.actions.ADBAction;

/**
 * 
 * @author randqm
 *
 */

public class ToggleAirplaneMode extends ADBAction {
	
	/**
	 * Whether to turn on or off.
	 */
	private final boolean on;
	
	
	/**
	 * Creates a new ADB action.
	 * 
	 * @param on Whether to turn on or off.
	 */
	public ToggleAirplaneMode(boolean on) {
		this.on = on;
	}
	
	@Override
	protected String[] getCommands() {
		return new String[] {
				"adb shell settings put global airplane_mode_on " + (on ? 1 : 0),
				"adb shell am broadcast -a android.intent.action.AIRPLANE_MODE"
		};
	}

}
