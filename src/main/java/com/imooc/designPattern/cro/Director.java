package com.imooc.designPattern.cro;

public class Director extends Leader {

	public Director(String name) {
		super(name);
	}

	@Override
	public void handleRequest(LeaveRequest request) {
		 if(request.getLeaveDays()<3) // 小于三天主任审批
	        {
	            System.out.println("主任" + getName() + "审批员工" + request.getLeaveName() 
	            + "的请假条，请假天数为" + request.getLeaveDays() + "天。");
	        }else{
	            if(getSuccessor()!=null)
	            {
	            	getSuccessor().handleRequest(request);
	            }
	        }
	}

}
