package com.imooc.algorithm;

import java.util.Comparator;

/**
 * 
 * <br>
 * 标题: <br>
 * 描述:折半查找（二分查找）是一種在有序數組中查找某一特定元素的搜索算法<br>
 * 單位:人生無限公司<br>
 * @autho chenzhiguan
 * @time 2018年11月23日 下午3:32:56
 */
public class BinarySearchTest {

	public static void main(String[] args) {
		Integer[] x = {1,2,3,4,5,6,7,8,9,10};
//		int superscript = binarySearch(x,5,new ComparatorByInt());
		int superscript =	binarySearch(x,5);
		System.out.println("-------------------->key的脚标为："+superscript);
	}
	
	public static <T extends Comparable<T>> int binarySearch(T[] x, T key) {
      return binarySearch(x, 0, x.length- 1, key);
   }

	/**
	 * 
	 * <br>
	 * 适用场景:	<br>
	 * 调用方式:	<br>
	 * 业务逻辑说明:使用循環實現的二分查找<br>
	 *
	 * @param x
	 * @param key
	 * @param comp
	 * @return
	 * @autho chenzhiguan
	 * @time 2018年11月23日 下午3:59:24
	 */
	public static <T> int binarySearch(T[] x,T key, Comparator<T> comp) {
		int low = 0;
		int hight = x.length-1;
		int mid = (low+hight) >>> 1;
		while(low <= hight) {
			if(comp.compare(key, x[mid])>0) {
				low = mid;
			}else if(comp.compare(key, x[mid])<0) {
				hight = mid;
			}else {
				return mid;
			}
		}
		return -1;
	}
	
	/**
	 * 
	 * <br>
	 * 适用场景:	<br>
	 * 调用方式:	<br>
	 * 业务逻辑说明:使用递归实现的二分查找<br>
	 *
	 * @param x
	 * @param low
	 * @param hight
	 * @param key
	 * @return
	 * @autho chenzhiguan
	 * @time 2018年11月23日 下午4:12:07
	 */
	public static <T extends Comparable<T>> int binarySearch(T[] x,int low , int hight, T key) {
		if(low <= hight) {
			int mid = (low+hight) >> 1;
			if(key.compareTo(x[mid])>0) {
				binarySearch(x,mid,hight,key);
			}else if(key.compareTo(x[mid])<0) {
				binarySearch(x,low,mid,key);
			}else {
				return mid;
			}
		}
		return -1;
	}
}
