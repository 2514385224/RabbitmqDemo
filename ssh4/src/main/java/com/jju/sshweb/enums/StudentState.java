package com.jju.sshweb.enums;


public enum StudentState {
	ERROR(404,"´íÎó"),ALLER(200,"Õý³£×´Ì¬");
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
	private StudentState() {
	}
	private StudentState(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public static StudentState getUserStateByCode(int code)
	{
		if(code==200)
		{
			return StudentState.ALLER;
		}else if(code==404)
		{
			return StudentState.ERROR;
		}else {
			return StudentState.ERROR;
		}
	}
}
