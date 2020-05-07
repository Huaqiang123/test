package com.jiangshan.test;

public class Express {

	private Integer km;
	
	private String city;

	public Express(Integer km, String city) {
		super();
		this.km = km;
		this.city = city;
	}

	public Integer getKm() {
		return km;
	}

	public void setKm(Integer km) {
		this.km = km;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public void checkKm() {
		synchronized(this) {
			while(this.getKm()<100) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(" express km is " + this.getKm());
		}
	}
	
	public void checkCity() {
		synchronized(this) {
			while("BeiJing".equals(this.getCity())) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(" express city is " + this.getCity());
		}
	}
	
	public void updateKm(Integer km) {
		synchronized (this) {
			this.km = km;
			this.notifyAll();
		}
	}	
	
	public void updateCity(String city) {
		synchronized (this) {
			this.city = city;
			this.notifyAll();
		}
	}

	@Override
	public String toString() {
		return "Express [km=" + km + ", city=" + city + "]";
	}
	
}
