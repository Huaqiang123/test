package com.jiangshan.test.sort;

public class Test001 {
	
	public static void main(String[] args) {
		Integer[] array = ArrayUtils.makeArray(1000, 10000);
		long begin = System.currentTimeMillis();
		Integer[] sortArray = InsertionSort.sort(array, 1);
//		Integer[] sortArray = MergeSort.sort(array, 1);
		long end = System.currentTimeMillis();
		System.out.println("Time:"+(end-begin));
		printArray(sortArray);
	}

	private static void printArray(Object[] array) {
		if(array!=null && array.length>0) {
			for(int i=0; i<array.length; i++) {
				System.out.println("["+i+":"+array[i]+"]");
			}
		}
	}
	
}
