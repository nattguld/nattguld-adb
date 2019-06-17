# nattguld-adb
An utility library for performing ADB commands from within a java application.

## Dependencies
You'll need Android SDK platform tools: https://dl.google.com/android/installer_r24.4.1-windows.exe  
Here's a guide to set it up: https://www.howtogeek.com/125769/how-to-install-and-use-abd-the-android-debug-bridge-utility/  

And optionally the nattguld-data library: https://github.com/nattguld/nattguld-data  
This is used for saving configurations and can be easily stripped out.

## Notes
Make sure you have turned on USB debugging on your device!  
The currently included ADB actions are tested for android version 5.1.0 to 6.0.1

## Example Usage
You can send straight up plane text commands or use ADB actions. There's a few ADB actions present but you will want to extend with the ones you need yourself. The difference is that an ADB action will execute multiple commands to handle an action rather than a single line command.
```java
ADBConfig.getConfig().setSDKToolsPath(pathToDirectory);

Dispatcher.sendCommand(commandLine);
Dispatcher.sendCommand(new ADBAction());
```
