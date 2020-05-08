package com.jiangshan.test;

import java.util.concurrent.CountDownLatch;

public class Test13 {
	
	private static CountDownLatch countDownLatch = new CountDownLatch(2);
	
	private static class UseThread extends Thread {

		@Override
		public void run() {
			try {
				Thread thread = Thread.currentThread();
				System.out.println("[start:"+thread.getName()+"]");
				Thread.sleep(5000);
				System.out.println("[end:"+thread.getName()+"]");
				countDownLatch.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		UseThread useThread1 = new UseThread();
		useThread1.start();
		UseThread useThread2 = new UseThread();
		useThread2.start();
		countDownLatch.await();
		System.out.println("main");
	}
	
}
