package com.jiangshan.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {

	private static class UseThread extends Thread {
		@Override
		public void run() {
			while(!isInterrupted()) {
				System.out.println(Thread.currentThread().getId() + ":" + Thread.currentThread().getName());
			}
		}
	}
	
	private static class UseRunnable implements Runnable {
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getId() + ":" + Thread.currentThread().getName());
		}
	}
	
	private static class UseCallable implements Callable<String> {
		@Override
		public String call() throws Exception {
			System.out.println(Thread.currentThread().getId() + ":" + Thread.currentThread().getName());
			return "Hello World !";
		}
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//Thread
		UseThread useThread = new UseThread();
//		new Thread(useThread).start();
		useThread.start();
		//Runnable
//		UseRunnable useRunnable = new UseRunnable();
//		new Thread(useRunnable).start();
//		//Callable
//		UseCallable useCallable = new UseCallable();
//		FutureTask<String> futureTask = new FutureTask<>(useCallable);
//		new Thread(futureTask).start();
//		System.out.println(futureTask.get());
		Thread.sleep(20);
		useThread.interrupt();
		System.out.println(Thread.currentThread().getId() + ":" + Thread.currentThread().getName());
	}
	
}
