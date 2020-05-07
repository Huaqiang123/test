package com.jiangshan.test;

public class Test005 {
	
	private static Data data = new Data();

	public static void main(String[] args) {
		
		data = null;
		System.gc();
	}
	
	static class Data {
		
		byte[] _200M = new byte[200*1024*1024];

		@Override
		protected void finalize() throws Throwable {
		
			System.out.println("回收:"+this.getClass().getName());
		}
				
	}
	
}
