package com.nattguld.adb;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import com.nattguld.adb.cfg.ADBConfig;

/**
 * 
 * @author randqm
 *
 */

public class Dispatcher {

	
	/**
	 * Sends a command to the connected devices.
	 * 
	 * @param command The command.
	 * 
	 * @return Whether the command was executed successfuly or not.
	 */
	public static boolean sendCommand(String command) {
		List<String> commands = new LinkedList<>();
		commands.add("cmd");
		commands.add("/c");
		commands.add(command);
		
		System.err.println("ADB command execute [" + command + "]");
		
		try {
			ProcessBuilder pb = new ProcessBuilder(commands);
			pb.directory(new File(ADBConfig.getConfig().getSDKToolsPath()));
			pb.redirectErrorStream(true);
			
			Process process = pb.start();
			
			try (BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
				String line = null;
	            
				while ((line = in.readLine()) != null) {            
					line = line.trim().toLowerCase();
					System.out.println("ADB: " + line);
				}
			}
			int exitCode = process.waitFor();
			//process.destroy();
			process.destroyForcibly();
			
			System.err.println("ADB exit code [" + exitCode + "]");
			return exitCode == 0;
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
