package com.jiangshan.test;

import java.util.Random;

public class Test11 {
	
	public static final int MAX_NUM = 10000;
	
	public static int[] createArray(int length) {
		if(length <= 0) {
			return null;
		}
		Random random = new Random();
		int[] array = new int[length];
		for(int i=0; i<length; i++) {
			array[i] = random.nextInt(MAX_NUM);
		}
		return array;
		
	}
	
	public static void main(String[] args) {
		int[] array = createArray(1000);
		if(array != null) {
			for(int i=0; i<array.length; i++) {
				System.out.println("["+i+":"+array[i]+"]");
			}
		}
	}

}
