package com.imooc.multithreading;

public class SingletonPatternDemo {
	//验证在多线程环境下懒汉式单例写法的不“安全”之处
	public static void main(String[] args) {
        Runnable task = ()->{
            String threadName = Thread.currentThread().getName();
            Singleton s1 = Singleton.getInstance();
            System.out.println("线程 " + threadName + "\t => " + s1.hashCode());
        };
        // 模拟多线程环境下使用 Singleton 类获得对象
        for(int i=0;i<1000;i++){
            new Thread(task,"" + i).start();
        }
    }
}
