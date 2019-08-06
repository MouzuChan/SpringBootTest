package com.imooc.designPattern.cro;

public class LeaveRequest {	//休假請求

	private String leaveName;//休假人
	private int leaveDays;//休假天數
	
	public LeaveRequest(String leaveName,int leaveDays) {
		this.leaveName = leaveName;
		this.leaveDays = leaveDays;
	}

	public String getLeaveName() {
		return leaveName;
	}

	public void setLeaveName(String leaveName) {
		this.leaveName = leaveName;
	}

	public int getLeaveDays() {
		return leaveDays;
	}

	public void setLeaveDays(int leaveDays) {
		this.leaveDays = leaveDays;
	}
	
	
}
