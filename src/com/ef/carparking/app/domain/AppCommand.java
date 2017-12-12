package com.ef.carparking.app.domain;

public class AppCommand {
	public int cmdid;
	public String cmdname;
	public AppCommand(int id,String name)
	{
		cmdid=id;
		cmdname=name;
	}
}
