package com.tribalpages.api.user;

public class TPSession {
	private boolean active;
	private String message;
	private int key;
	private int memberid;

	public String getMessage() {
		return message;
	}
	public int getKey() {
		return key;
	}
	public int getMemberid() {
		return memberid;
	}
	TPSession(String message) {
		this.message = message;
		key = -1;
		memberid = -1;
		active = false;
	}
	public boolean isActive() {
		return active;
	}
	TPSession(int key, int memberid) {
		this.message = "Login ok";
		this.key = key;
		this.memberid = memberid;
		active = true;
	}
}
