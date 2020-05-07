package com.jiangshan.test;

public class Test12 {
	
	private static class ExpressKm extends Thread {
		private Express express;
		public ExpressKm(Express express) {
			this.express = express;
		}
		@Override
		public void run() {
			this.express.checkKm();
		}
	}

	private static class ExpressCity extends Thread {
		private Express express;
		public ExpressCity(Express express) {
			this.express = express;
		}
		@Override
		public void run() {
			this.express.checkCity();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Express express = new Express(0, "BeiJing");
		new ExpressKm(express).start();
		new ExpressCity(express).start();
		Thread.sleep(5000);
		express.updateKm(100);
		Thread.sleep(5000);
		express.updateCity("ShangHai");
	}
	
}