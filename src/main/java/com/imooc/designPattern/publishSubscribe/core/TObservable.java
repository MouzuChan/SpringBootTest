package com.imooc.designPattern.publishSubscribe.core;

public interface TObservable {

	public void registerObserver(BaseToServer baseToserver);
	
	public void removeObserver(BaseToServer baseToserver);
	
	public void notifyObsevers();
	
	public void dataChange(BaseData baseData);
}
