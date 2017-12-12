package com.ef.carparking.app.domain;

import java.util.HashMap;
import java.util.Map;

public class AppCommandUtil {
	protected static Map<String,AppCommand> CommandNameMap;
	protected static AppCommand[] CommandArray;
	
	public static final int COUNT_APPCMD=6;
	public static final int APPCMD_LOGIN=0;
	public static final int APPCMD_LISTDEVS=1;
	public static final int APPCMD_GETDEV=2;
	public static final int APPCMD_OPDEV=3;
	public static final int APPCMD_WATCHDEV=4;
	public static final int APPCMD_DEWATCHDEV=5;
	
	static
	{
		CommandNameMap=new HashMap<String,AppCommand>();
		
		CommandArray=new AppCommand[COUNT_APPCMD];
		
		AppCommand cmd=new AppCommand(APPCMD_LOGIN,"login");
		CommandNameMap.put(cmd.cmdname, cmd);
		CommandArray[APPCMD_LOGIN]=cmd;
		
		cmd=new AppCommand(APPCMD_LISTDEVS,"listdevs");
		CommandNameMap.put(cmd.cmdname, cmd);
		CommandArray[APPCMD_LISTDEVS]=cmd;
		
		cmd=new AppCommand(APPCMD_GETDEV,"getdev");
		CommandNameMap.put(cmd.cmdname, cmd);
		CommandArray[APPCMD_GETDEV]=cmd;
		
		cmd=new AppCommand(APPCMD_WATCHDEV,"watchdev");
		CommandNameMap.put(cmd.cmdname, cmd);
		CommandArray[APPCMD_WATCHDEV]=cmd;
		
		cmd=new AppCommand(APPCMD_DEWATCHDEV,"dewatchdev");
		CommandNameMap.put(cmd.cmdname, cmd);
		CommandArray[APPCMD_DEWATCHDEV]=cmd;
	}
	
	public static AppCommand getCommand(String name)
	{
		return CommandNameMap.get(name);
	}
	
	public static AppCommand getCommand(int cmdid)
	{
		return CommandArray[cmdid];
	}
}
