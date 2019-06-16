package com.nattguld.adb.actions.impl;

import com.nattguld.adb.actions.ADBAction;

/**
 * 
 * @author randqm
 *
 */

public class ConnectionCheck extends ADBAction {

	
	@Override
	protected String[] getCommands() {
		return new String[] {
				"adb devices"
		};
	}

}
