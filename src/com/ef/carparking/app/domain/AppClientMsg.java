package com.ef.carparking.app.domain;

import java.net.InetAddress;
import java.util.Date;
import java.util.List;

import com.ef.carparking.util.UtilTools;

public class AppClientMsg {
	protected String sn;
	protected String token;
	protected String cmd;
	protected List<AppCmdArg> args;
	
	protected InetAddress remoteaddr;
	protected int remoteport;
	
	
	public String getSn() {
		return sn;
	}

	public void setSn(String id) {
		this.sn = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCmd() {
		return cmd;
	}
	
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	
	public List<AppCmdArg> getArgs() {
		return args;
	}
	
	public void setArgs(List<AppCmdArg> args) {
		this.args = args;
	}

	public InetAddress getRemoteaddr() {
		return remoteaddr;
	}

	public int getRemoteport() {
		return remoteport;
	}

	public void setRemote(InetAddress remote,int port) {
		this.remoteaddr = remote;
		this.remoteport = port;
	}

	public String getContent()
	{
		return UtilTools.sglobalGson.toJson(this.args);
	}
}
