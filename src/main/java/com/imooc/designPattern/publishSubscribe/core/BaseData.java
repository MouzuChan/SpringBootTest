package com.imooc.designPattern.publishSubscribe.core;

public abstract class BaseData {

	private String dataId;

	public BaseData(String dataId) {
		this.dataId = dataId;
	}
	public String getDataId() {
		return dataId;
	}

	public void setDataId(String dataId) {
		this.dataId = dataId;
	}
	
	
}
