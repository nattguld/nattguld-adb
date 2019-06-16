package com.nattguld.adb.cfg;

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
	


	@Override
	protected void read(JsonReader reader) {
		this.sdkToolsPath = reader.getAsString("sdk_tools_path", null);
	}

	@Override
	protected void write(JsonWriter writer) {
		writer.write("sdk_tools_path", sdkToolsPath);
	}
	
	@Override
	protected String getSaveFileName() {
		return ".adb_config";
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
	 * Retrieves the config.
	 * 
	 * @return The config.
	 */
	public static ADBConfig getConfig() {
		return (ADBConfig)ConfigManager.getConfig(new ADBConfig());
	}
 
}