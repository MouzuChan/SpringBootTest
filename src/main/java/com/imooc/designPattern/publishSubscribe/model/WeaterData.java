package com.imooc.designPattern.publishSubscribe.model;

import com.imooc.designPattern.publishSubscribe.core.BaseData;

public class WeaterData extends BaseData {

	public WeaterData(String dataId) {
		super(dataId);
	}
	
	private int temperature;
	
	private int humidity;

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	
	

}
