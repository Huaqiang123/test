package com.jiangshan.test.sort;

import java.util.Arrays;

public class MergeSort {
	
	private static final Integer THRESHOLD = 1000;

	public static Integer[] sort(Integer[] array, Integer order) {
		
		if((array==null || array.length==0) || (order==null || order==0)) {
			return array;
		}
		if(array.length<=THRESHOLD) {
			return InsertionSort.sort(array, order);
		}
		int length = array.length;
		int mid = length/2;
		Integer[] array1 = Arrays.copyOfRange(array, 0, mid);
		Integer[] array2 = Arrays.copyOfRange(array, mid, length);		
		return merge(sort(array1, order), sort(array2, order), order);
	}
	
	private static Integer[] merge(Integer[] array1, Integer[] array2, Integer order) {
		
		Integer[] array = new Integer[array1.length+array2.length];
		for(int index=0, i=0, j=0; index<array.length; index++) {
			if(i>=array1.length) {
				array[index] = array2[j++];
			} else if(j>=array2.length) {
				array[index] = array1[i++];
			} else {
				if((array1[i]>array2[j]) && (order>0)) {
					array[index] = array2[j++];
				} else {
					array[index] = array1[i++];
				}
			}
		}
		return array;
	}
	
}
