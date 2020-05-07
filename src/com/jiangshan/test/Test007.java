package com.jiangshan.test;

public class Test007 {

	private static class ThreadRun extends Thread {

		@Override
		public void run() {	
			for(int i=10; i>0; i--) {
				System.out.println("Thread:"+Thread.currentThread().getName());
				System.out.println("Thread:"+this.getName());
			}
		}
		
	}
	
	public static void main(String[] args) {
			
		ThreadRun threadRun = new ThreadRun();
		threadRun.setName("ThreadRun");
		new Thread(threadRun).start();
	}
	
}
