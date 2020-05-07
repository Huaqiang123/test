package com.jiangshan.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class Test002 {

	public static void main(String[] args) {
		Integer[] array = ArrayUtils.makeArray(100000, 10000);
		long begin = System.currentTimeMillis();
		ForkJoinPool pool = new ForkJoinPool();
		SumTask task = new SumTask(array);
		pool.invoke(task);
		long end = System.currentTimeMillis();
		System.out.println("[sum:"+task.join()+"]");
		System.out.println("[time:"+(end-begin)+"]");
	}
	
}
