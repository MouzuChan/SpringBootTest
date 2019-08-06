package com.imooc.multithreading;

public class MySingleton {
private static MySingleton instance = null;
	
	private MySingleton(){}
	
	public synchronized static MySingleton getInstance() {
		try { 
			if(instance != null){//懒汉式 
				
			}else{
				//创建实例之前可能会有一些准备性的耗时工作 
				Thread.sleep(3000);
				instance = new MySingleton();
			}
		} catch (InterruptedException e) { 
			e.printStackTrace();
		}
		return instance;
		/*if(instance == null){//懒汉式
			instance = new MySingleton();
		}
		return instance;*/

	}

}
