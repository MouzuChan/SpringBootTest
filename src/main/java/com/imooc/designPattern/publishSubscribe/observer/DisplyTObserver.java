package com.imooc.designPattern.publishSubscribe.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imooc.designPattern.publishSubscribe.core.BaseData;
import com.imooc.designPattern.publishSubscribe.core.BaseToServer;
import com.imooc.designPattern.publishSubscribe.model.CarData;
import com.imooc.designPattern.publishSubscribe.model.WeaterData;

public class DisplyTObserver extends BaseToServer {

	private static Logger LOGGER = LoggerFactory.getLogger(DisplyTObserver.class);
	public DisplyTObserver(String observerId) {
		super(observerId);
	}

	@Override
	public void update(BaseData baseData) {
		if(baseData instanceof WeaterData) {
			WeaterData data = (WeaterData)baseData;
			LOGGER.info(" Current observer receive WeaterData ----> {} - {}"
					,data.getHumidity(),data.getTemperature());
		}else if(baseData instanceof CarData){
			CarData carData = (CarData)baseData;
			LOGGER.info(" Current observer receive CarData ----> {} - {}"
					,carData.getCarNum(),carData.getCarStatus());
		}
	}

	@Override
	public void init(BaseData baseData) {
		// TODO Auto-generated method stub

	}

}
