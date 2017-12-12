package com.ef.carparking.app.domain;

import java.util.Date;

public class AppMsgLog {
	protected int rid;
	protected AppClientInfo info;
	protected AppClientMsg msg;
	protected Date msgdate;
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public AppClientInfo getInfo() {
		return info;
	}
	public void setInfo(AppClientInfo info) {
		this.info = info;
	}
	public AppClientMsg getMsg() {
		return msg;
	}
	public void setMsg(AppClientMsg msg) {
		this.msg = msg;
	}
	public Date getMsgdate() {
		return msgdate;
	}
	public void setMsgdate(Date msgdate) {
		this.msgdate = msgdate;
	}	
	
	
}
