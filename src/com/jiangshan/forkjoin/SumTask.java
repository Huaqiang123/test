package com.jiangshan.forkjoin;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Integer> {
	
	private static final Integer THRESHOLD = 1000;

	private Integer[] array;
	
	public SumTask(Integer[] array) {
		
		this.array = array;
	}
	
	@Override
	protected Integer compute() {
		
		if(array==null)
			return 0;
		if(array.length<=THRESHOLD) {
			Integer sum = 0;
			for(int i=0; i<array.length; i++) {
				sum += array[i];
			}
			return sum;
		}
		int length = array.length;
		int mid = length/2;
		Integer[] array1 = Arrays.copyOfRange(array, 0, mid);
		Integer[] array2 = Arrays.copyOfRange(array, mid, length);	
		SumTask task1 = new SumTask(array1);
		SumTask task2 = new SumTask(array2);
		invokeAll(task1, task2);
		return task1.join() + task2.join();
	}

}
