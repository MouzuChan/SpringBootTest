package com.imooc.designPattern.publishSubscribe.core;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Subject implements TObservable {

	public static Logger LOGGER = LoggerFactory.getLogger(Subject.class);
	
	private BaseData data;
	private ConcurrentHashMap<String, BaseToServer> submap = new ConcurrentHashMap<>();
	
	@Override
	public void registerObserver(BaseToServer baseToServer) {
		submap.put(baseToServer.getObserverId(), baseToServer);
	}

	@Override
	public void removeObserver(BaseToServer baseToServer) {
		if(submap.containsKey(baseToServer.getObserverId())) {
			submap.remove(baseToServer.getObserverId());
		}else {
			LOGGER.info("---------------> remove failed "+ baseToServer.getObserverId());
		}

	}

	@Override
	public void notifyObsevers() {
		Set<Map.Entry<String,BaseToServer>> entrySet = submap.entrySet();
		for(Map.Entry<String, BaseToServer> entry :entrySet) {
			entry.getValue().update(data);
		}

	}

	@Override
	public void dataChange(BaseData baseData) {
		this.data = baseData;
		notifyObsevers();
	}

	public int getMapSize() {
		return submap.size();
	}
}
