package com.jiangshan.thread;

import java.util.LinkedList;
import java.util.Random;

public class Gun {

	public static final Integer CAPACITY = 20;
	
	private LinkedList<Bullet> bullets = new LinkedList<Bullet>();
	
	public void shoot() {
		synchronized (bullets) {
			Random random = new Random();
			Integer num = random.nextInt(Gun.CAPACITY)+1;
			System.err.println("shoot num is " + num);
			for(int i=0; i<num; i++) {
				while(bullets.isEmpty()) {
					try {
						bullets.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Bullet bullet = bullets.removeLast();
				System.out.println("shoot:["+bullet+"]");
				System.out.println("Bullet:"+System.identityHashCode(bullet));
				System.out.println("---------->");
			}
		}
	}
	
	public void loading() {
		synchronized (bullets) {
			if(bullets.isEmpty()) {
				for(int i=bullets.size()+1; i<=Gun.CAPACITY; i++) {
					Bullet bullet = new Bullet(i, "第"+i+"颗子弹");
					bullets.addLast(bullet);
//					System.out.println("loading:["+bullet+"]");
//					System.out.println("Bullet:"+System.identityHashCode(bullet));
				}
				bullets.notifyAll();
			}
		}
	}

	public LinkedList<Bullet> getBullets() {
		return bullets;
	}

	public void setBullets(LinkedList<Bullet> bullets) {
		this.bullets = bullets;
	}
	
}
