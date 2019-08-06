package com.imooc.designPattern.publishSubscribe.core;

public abstract class BaseToServer implements TObserver {

	private String observerId;
	
	public BaseToServer(String observerId) {
		this.observerId = observerId;
	}
	
	public abstract void update(BaseData baseData);
	
	public abstract void init(BaseData baseData);
	
	public String getObserverId() {
		return observerId;
	}


	public void setObserverId(String observerId) {
		this.observerId = observerId;
	}


	@Override
	public void TestHandle() {
		// TODO Auto-generated method stub

	}

}
