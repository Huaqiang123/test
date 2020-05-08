package com.jiangshan.forkjoin;

import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Integer> {

	private static final long serialVersionUID = 3426964350248012497L;

	private static final Integer THRESHOLD = 1000;
	
	private Integer[] array;
	
	private Integer fromIndex;
	
	private Integer toIndex;
	
	public SumTask(Integer[] array, Integer fromIndex, Integer toIndex) {
		this.array = array;
		this.fromIndex = fromIndex;
		this.toIndex = toIndex;
	}

	@Override
	protected Integer compute() {
		
		if(array==null) {
			return 0;
		}
		if((toIndex-fromIndex+1)<=THRESHOLD) {
			Integer sum = 0;
			for(int i=fromIndex; i<=toIndex; i++) {
				sum += array[i];
			}
			return sum;
		} else {
			Integer mid = (fromIndex+toIndex)/2;
			SumTask leftTask = new SumTask(array, fromIndex, mid);
			SumTask rightTask = new SumTask(array, mid+1, toIndex);
			invokeAll(leftTask, rightTask);
			return leftTask.join() + rightTask.join();
		}
	}
	
}
