package com.jiangshan.test;

public class Test008 {
	
	static ThreadLocal<String> threadLocal = new ThreadLocal<String>();
	
	public static void print(String name) {
		System.out.println(name + ":" + threadLocal.get());
		threadLocal.remove();
	}

	public static void main(String[] args) {
		
		for(int i=0; i<100; i++) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					threadLocal.set(Thread.currentThread().getName());
					print(Thread.currentThread().getName());
				}
			});
			thread.start();
		}
		
	}
	
}
