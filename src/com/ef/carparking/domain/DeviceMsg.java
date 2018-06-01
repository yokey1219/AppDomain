package com.ef.carparking.domain;

import java.net.InetAddress;
import java.util.Date;

public class DeviceMsg {
	protected byte[] msgbuffer;
	protected int msgno; //2-byte,0~65535,装置消息ID,用于重发机制
	protected int cmdid; //2-byte,0~65535,命令ID,用于命令处理
	protected int seriallen;//1-byte,0~255,IMEI号长度
	protected String serialno;//n-byte,n=seriallen,IMEI号,长度由searillen确定
	protected int datalen;//2-byte,0~65535,数据长度
	protected byte[] databuffer;//n-byte,n=datalen,命令具体数据，长度由datalen确定
	protected int dataidx;
	protected boolean avilable;
	
	protected Date recvat;
	protected InetAddress remoteaddr;
	protected int remoteport;
	

	public byte[] getMsgbuffer() {
		return msgbuffer;
	}

	public void setMsgbuffer(byte[] msgbuffer) {
		this.msgbuffer = msgbuffer;
	}

	public int getMsgno() {
		return msgno;
	}

	public void setMsgno(int msgno) {
		this.msgno = msgno;
	}

	public int getCmdid() {
		return cmdid;
	}

	public void setCmdid(int cmdid) {
		this.cmdid = cmdid;
	}

	public int getSeriallen() {
		return seriallen;
	}

	public void setSeriallen(int seriallen) {
		this.seriallen = seriallen;
	}

	public String getSerialno() {
		return serialno;
	}

	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}

	public int getDatalen() {
		return datalen;
	}

	public void setDatalen(int datalen) {
		this.datalen = datalen;
	}

	public byte[] getDatabuffer() {
		return databuffer;
	}

	public void setDatabuffer(byte[] databuffer) {
		this.databuffer = databuffer;
	}

	public int getDataidx() {
		return dataidx;
	}

	public void setDataidx(int dataidx) {
		this.dataidx = dataidx;
	}
	
	
	
	public boolean isAvilable() {
		return avilable;
	}

	


	public Date getRecvat() {
		return recvat;
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




	public static final int CMDID_LOGIN=0;
	public static final int CMDID_STATESYNC=1;
	public static final int CMDID_REPORTCARPARKING=2;
	public static final int CMDID_REPORTSTATUS=3;
	public static final int CMDID_QUERYMODE=4;
	
	
	protected static final int MINLEN=10;
	
	public DeviceMsg(byte[] buffer,int length)
	{
		recvat=new Date();
		this.avilable=false;

		//msgbuffer=buffer.clone();
		msgbuffer=new byte[length];
		System.arraycopy(buffer,0, msgbuffer, 0, length);
		if(msgbuffer.length>=MINLEN)
		{
			msgno=(int)(msgbuffer[0]<<8)+msgbuffer[1];
			cmdid=(int)(msgbuffer[2]<<8)+msgbuffer[3];
			seriallen=(int)(msgbuffer[4]);
			
			serialno=new String(msgbuffer,5,seriallen);
			
			datalen=(int)(msgbuffer[5+seriallen]<<8)+msgbuffer[6+seriallen];
			dataidx=7+seriallen;
			databuffer=new byte[datalen];
			if(datalen!=(msgbuffer.length-seriallen-7))
			{
				//TODO here 数据长度不对的情况
				System.out.println(String.format("lentherror,datalen:%d,buflen:%d,snlen:%d",datalen,msgbuffer.length,seriallen ));
				for(int i=0;i<msgbuffer.length;i++)
					System.out.print(String.format("%02X", msgbuffer[i]));
			}
			System.arraycopy(msgbuffer,dataidx, databuffer, 0, datalen);
			this.avilable=true;
			
		}
	}
	
	public byte[] makeACK()
	{
		byte[] ack=new byte[4];
		System.arraycopy(msgbuffer, 0, ack, 0, ack.length);
		return ack;
	}
	
	public String getHexContent()
	{
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<datalen;i++)
			sb.append(String.format("%02X", databuffer[i]));
		return sb.toString();
	}
	
}
