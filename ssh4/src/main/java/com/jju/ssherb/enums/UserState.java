package com.jju.ssherb.enums;



public enum UserState {
	NOTATION(404,"Î´¼¤»î×´Ì¬"),ACTIVATION(200,"¼¤»î×´Ì¬");
	private int code;
	private String msg;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	private UserState(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	private UserState() {
	}
	public static UserState getUserStateByCode(int code)
	{
		if(code==200)
		{
			return UserState.ACTIVATION;
		}else if(code==404)
		{
			return UserState.NOTATION;
		}else {
			return UserState.NOTATION;
		}
	}
	
}