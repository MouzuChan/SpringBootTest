package com.imooc.designPattern.cro;

public abstract class Leader {	//抽象處理者

	private String name;
	private Leader successor;
	
	public Leader(String name) {
		this.name = name;
	}
	
	public void setSuccessor(Leader successor) {
		//設置下一個處理者
		this.successor = successor;
	}

	public abstract void handleRequest(LeaveRequest request);//處理請求

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Leader getSuccessor() {
		return successor;
	}
	
}
