package com.jiangshan.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test006 {

	private static class UseThread extends Thread {

		@Override
		public void run() {
			System.out.println(" use thread ");
		}
		
	}
	
	private static class UseRunnable implements Runnable {

		@Override
		public void run() {
			System.out.println(" use runnable ");
		}
		
	}
	
	private static class UseCallable implements Callable<String> {

		@Override
		public String call() throws Exception {
			System.out.println(" use callable ");
			return " use callable ";
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		UseThread useThread = new UseThread();
		new Thread(useThread).start();
		UseRunnable useRunnable = new UseRunnable();
		new Thread(useRunnable).start();
		UseCallable useCallable = new UseCallable();
		FutureTask<String> futureTask = new FutureTask<String>(useCallable);
		new Thread(futureTask).start();
		System.out.println(futureTask.get());
		
	}
	
}
