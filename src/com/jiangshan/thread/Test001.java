package com.jiangshan.thread;

public class Test001 {

	private static class GunShoot extends Thread {
		private Gun gun;
		public GunShoot(Gun gun) {
			this.gun = gun;
		}
		@Override
		public void run() {
			while(true) {
				this.gun.shoot();
			}
		}
	}
	
	private static class GunLoading extends Thread {
		private Gun gun;
		public GunLoading(Gun gun) {
			this.gun = gun;
		}
		@Override
		public void run() {
			while(true) {
				this.gun.loading();
			}
		}
	}
	
	public static void main(String[] args) {
		
		Gun gun = new Gun();
		new GunShoot(gun).start();
		new GunLoading(gun).start();
		
	}
	
}
