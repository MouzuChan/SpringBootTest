package com.imooc.designPattern.cro;

public class ViceGeneralManager extends Leader {

	public ViceGeneralManager(String name) {
		super(name);
	}

	@Override
	public void handleRequest(LeaveRequest request) {
		if(request.getLeaveDays()<20) // 小于20天经理审批
        {
            System.out.println("副总经理" + getName() + "审批员工" + request.getLeaveName() 
            + "的请假条，请假天数为" + request.getLeaveDays() + "天。");
        }else{
            if(getSuccessor()!=null)
            {
            	getSuccessor().handleRequest(request);
            }
        }

	}

}
