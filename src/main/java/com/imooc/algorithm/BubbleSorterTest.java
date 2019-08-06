package com.imooc.algorithm;

/**
 * 
 * <br>
 * 标题: <br>
 * 描述: 冒泡排序<br>
 * 單位:人生無限公司<br>
 * @autho chenzhiguan
 * @time 2018年11月23日 上午11:02:10
 */
public class BubbleSorterTest {

	public static void main(String[] args) {
		/*Integer[] list = {7,4,19,30,10,60,48,6,2,50};
		BubbleSorter bubble = new BubbleSorter();
		bubble.sort(list);
		System.out.println("排序為：");
		for(Integer i : list) {
		System.out.println(i);
		}*/
		System.out.println("---------------------------------");
		int[] A = {7,4,19,30,10,60,48,6,2,50};
		bubbleSort(A);
		for(int i : A) {
			System.out.println(i);
		}
	}

	
	public static void bubbleSort(int A[]) {
		int length = A.length;
		for(int i=0; i<length-1; i++) { //進行length-1輪比較
			for(int j=0; j<length-1-i; j++) {
				if(A[j]>A[j+1]) {	//順序排序
					int temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
				}
			}
		}
	}
	
	
}
