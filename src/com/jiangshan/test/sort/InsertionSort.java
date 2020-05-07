package com.jiangshan.test.sort;

import java.util.Arrays;

public class InsertionSort {
	
	public static Integer[] sort(Integer[] array, Integer order) {
		
		if((array==null || array.length==0) || (order==null || order==0)) {
			return null;
		}
		if(order>0) {
			return orderByAsc(array);
		} else {
			return orderByDesc(array);
		}
	}
	
	private static Integer[] orderByAsc(Integer[] array) {
		
		Integer[] sortArray = Arrays.copyOf(array, array.length);
		for(int i=1; i<sortArray.length; i++) {
			int index = i;
			int value = sortArray[i];
			while(index>=1 && sortArray[index-1]>value) {
				sortArray[index] = sortArray[index-1];
				index--;
			}
			sortArray[index] = value;
		}
		return sortArray;
	}
	
	private static Integer[] orderByDesc(Integer[] array) {
		
		Integer[] sortArray = Arrays.copyOf(array, array.length);
		for(int i=1; i<sortArray.length; i++) {
			int index = i;
			int value = sortArray[i];
			while(index>=1 && sortArray[index-1]<value) {
				sortArray[index] = sortArray[index-1];
				index--;
			}
			sortArray[index] = value;
		}
		return sortArray;
	}
	
}
