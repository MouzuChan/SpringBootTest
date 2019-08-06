package com.imooc.algorithm;

import java.util.Comparator;

/**
 * 
 * <br>
 * 标题: <br>
 * 描述: 排序器接口(策略模式: 将算法封装到具有共同接口的独立的类中使得它们可以相互替换)<br>
 * 單位:人生無限公司<br>
 * @autho chenzhiguan
 * @time 2018年11月23日 上午10:41:36
 */
public interface Sorter {

	  /**
	    * 排序
	    * @param list 待排序的数组
	    */
	   public <T extends Comparable<T>> void sort(T[] list);
	 
	   /**
	    * 排序
	    * @param list 待排序的数组
	    * @param comp 比较两个对象的比较器
	    */
	   public <T> void sort(T[] list, Comparator<T> comp);
}
