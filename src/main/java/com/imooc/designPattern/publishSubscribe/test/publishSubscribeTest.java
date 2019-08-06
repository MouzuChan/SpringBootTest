package com.imooc.designPattern.publishSubscribe.test;

import com.imooc.designPattern.publishSubscribe.model.CarData;
import com.imooc.designPattern.publishSubscribe.model.WeaterData;
import com.imooc.designPattern.publishSubscribe.observer.CurrentTObserver;
import com.imooc.designPattern.publishSubscribe.observer.DisplyTObserver;
import com.imooc.designPattern.publishSubscribe.subject.CarSubjectContainer;
import com.imooc.designPattern.publishSubscribe.subject.WeatherSubjectContainer;

public class publishSubscribeTest {

	public static void main(String[] args) {
		
		//init register
	    //1.currentTObserver，displyTObserver两个观察者(客户端)。
	    CurrentTObserver currentTObserver=new CurrentTObserver("CurObserver1");
	    DisplyTObserver displyTObserver=new DisplyTObserver("DisObserver");

	    //2.两个观察者(客户端)订阅了不同类型，品种的数据。currentTObserver订阅了两种个容器的数据，另外一个只订阅了天气容器中的数据。
	    WeatherSubjectContainer.getInstance().registerObserver(currentTObserver);
	    WeatherSubjectContainer.getInstance().registerObserver(displyTObserver);
	    CarSubjectContainer.getInstance().registerObserver(currentTObserver);
	    
	    
	    //3.WeatherSubjectContainer和CarSubjectContainer两种数据发生了改变的时候，调用自己的dateChange方法，两个客户端就可以收到对应数据了。
	    //4.扩展数据品种增加一个container，增加一种数据类型即可。
	    int te = 1;
	    int hum = 3;
	    while (true) {
	        try {
	            Thread.sleep(1000);
	            System.out.println(" data rescore push data ...");
	            te++;
	            hum++;
	            WeaterData weaterData = new WeaterData("WD_DATA");
	            weaterData.setTemperature(te);
	            weaterData.setHumidity(hum);
	            WeatherSubjectContainer.getInstance().dataChange(weaterData);
	            CarData carData = new CarData("CAR_DATA");
	            carData.setCarNum("CarA0000");
	            carData.setCarStatus("空");
	            CarSubjectContainer.getInstance().dataChange(carData);
	            //模拟取消订阅
	            if (te>5){
	                WeatherSubjectContainer.getInstance().removeObserver(currentTObserver);
	            }
	            System.out.println("WE->"+WeatherSubjectContainer.getInstance().getMapSize());
	            System.out.println("Cr->"+CarSubjectContainer.getInstance().getMapSize());
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	    }
	}

}
