package com.jiangshan.forkjoin;

public class Test001 {

	public static void main(String[] args) {
		Integer[] array = ArrayUtils.makeArray(100000, 10000);
		long begin = System.currentTimeMillis();
		Integer sum = 0;
		for(int i=0; i<array.length; i++) {
			sum += array[i];
		}
		long end = System.currentTimeMillis();
		System.out.println("[sum:"+sum+"]");
		System.out.println("[time:"+(end-begin)+"]");
	}
	
}
