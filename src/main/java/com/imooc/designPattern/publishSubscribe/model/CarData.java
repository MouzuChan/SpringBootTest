package com.imooc.designPattern.publishSubscribe.model;

import com.imooc.designPattern.publishSubscribe.core.BaseData;

public class CarData extends BaseData {

	public CarData(String dataId) {
		super(dataId);
	}
	
	private String carNum;
	
	private String carStatus;

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public String getCarStatus() {
		return carStatus;
	}

	public void setCarStatus(String carStatus) {
		this.carStatus = carStatus;
	}
	
}
