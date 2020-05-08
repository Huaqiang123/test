package com.jiangshan.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class Test003 {

	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		FileTask fileTask = new FileTask("exe", "G:/");
		pool.execute(fileTask);
		fileTask.join();
	}
	
}
