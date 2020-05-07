package com.jiangshan.test.sort;

import java.util.Random;

public class ArrayUtils {
	
	public static Integer[] makeArray(Integer length, Integer maxNum) {
		
		if((length==null || length<=0) || (maxNum==null || maxNum<=0)) {
			return null;
		}
		Random random = new Random();
		Integer[] array = new Integer[length];
		for(int i=0; i<length; i++) {
			array[i] = random.nextInt(maxNum);
		}
		return array;
	}
	
}
