package com.jiangshan.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class Test002 {
	
	public static void main(String[] args) {
		Integer[] array = ArrayUtils.makeArray(10000, 10000);
		long begin = System.currentTimeMillis();
		ForkJoinPool pool = new ForkJoinPool();
		SumTask sumTask = new SumTask(array, 0, array.length-1);
		pool.invoke(sumTask);
		long end = System.currentTimeMillis();
		System.out.println("[sum:"+sumTask.join()+",time:"+(end-begin)+"]");
	}
	
}
