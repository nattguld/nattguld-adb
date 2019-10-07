package com.nattguld.adb.cfg;

import java.util.Objects;

import com.nattguld.data.cfg.Config;
import com.nattguld.data.cfg.ConfigManager;
import com.nattguld.data.json.JsonReader;
import com.nattguld.data.json.JsonWriter;

/**
 * 
 * @author randqm
 *
 */

public class ADBConfig extends Config {
	
	/**
	 * The SDK tools path.
	 */
	private String sdkToolsPath;
	
	/**
	 * The error ip.
	 */
	private String errorIP;
	


	@Override
	protected void read(JsonReader reader) {
		this.sdkToolsPath = reader.getAsString("sdk_tools_path", null);
		this.errorIP = reader.getAsString("error_ip", null);
	}

	@Override
	protected void write(JsonWriter writer) {
		writer.write("sdk_tools_path", sdkToolsPath);
		writer.write("error_ip", errorIP);
	}
	
	@Override
	protected String getSaveFileName() {
		return ".adb_config";
	}
	
	/**
	 * Retrieves whether ADB is setup or not.
	 * 
	 * @return The result.
	 */
	public boolean isSetup() {
		return Objects.nonNull(getSDKToolsPath());
	}
	
	/**
	 * Modifies the SDK tools path.
	 * 
	 * @param sdkToolsPath The new path.
	 * 
	 * @return The config.
	 */
	public ADBConfig setSDKToolsPath(String sdkToolsPath) {
		this.sdkToolsPath = sdkToolsPath;
		return this;
	}
	
	/**
	 * Retrieves the SDK tools path.
	 * 
	 * @return The path.
	 */
	public String getSDKToolsPath() {
		return sdkToolsPath;
	}
	
	/**
	 * Modifies the error IP.
	 * 
	 * @param errorIP The new error IP.
	 * 
	 * @return The config.
	 */
	public ADBConfig setErrorIP(String errorIP) {
		this.errorIP = errorIP;
		return this;
	}
	
	/**
	 * Retrieves the error IP.
	 * 
	 * @return The error IP.
	 */
	public String getErrorIP() {
		return errorIP;
	}
	
	/**
	 * Retrieves whether an error IP is set or not.
	 * 
	 * @return The result.
	 */
	public boolean hasErrorIP() {
		return Objects.nonNull(getErrorIP()) && !getErrorIP().isEmpty();
	}
	
	/**
	 * Retrieves the config.
	 * 
	 * @return The config.
	 */
	public static ADBConfig getConfig() {
		return (ADBConfig)ConfigManager.getConfig(new ADBConfig());
	}
 
}
