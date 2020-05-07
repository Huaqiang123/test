package com.jiangshan.test;

public class Test10 {
	
	private static class UseThread extends Thread {

		@Override
		public void run() {
			while(!isInterrupted()) {
				System.out.println(" use thread ");
				Thread.currentThread().interrupt();
				System.out.println("interrupt:" + isInterrupted());
			}
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		UseThread useThread = new UseThread();
		Thread thread = new Thread(useThread);
		thread.start();
		Thread.sleep(100);
		thread.interrupt();
		System.out.println("Hello World !");
	}
	
}
