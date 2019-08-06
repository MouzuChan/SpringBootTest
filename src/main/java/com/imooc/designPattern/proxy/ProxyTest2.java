package com.imooc.designPattern.proxy;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <br>
 * 标题: <br>
 * 描述: 从JDK 1.3开始，Java提供了动态代理技术，允许开发者在运行时创建接口的代理实例，主要包括Proxy类和InvocationHandler接口。
 * 		下面的例子使用动态代理为ArrayList编写一个代理，在添加和删除元素时，在控制台打印添加或删除的元素以及ArrayList的大小<br>
 * 單位:人生無限公司<br>
 * @autho chenzhiguan
 * @time 2018年12月13日 上午10:43:05
 */
public class ProxyTest2 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
        Class<?> clazz = list.getClass();
        ListProxy<String> myProxy = new ListProxy<String>(list);
        List<String> newList = (List<String>) 
                Proxy.newProxyInstance(clazz.getClassLoader(), 
                clazz.getInterfaces(), myProxy);
        newList.add("apple");
        newList.add("banana");
        newList.add("orange");
        newList.remove("banana");

	}

}
