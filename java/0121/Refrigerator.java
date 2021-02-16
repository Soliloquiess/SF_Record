package com.ssafy.algo;


public class Refrigerator {
	private int number;
	private String name;
	private int value;
	private int count;
	private int vol;
	
	public Refrigerator(int number, String name, int value, int count, int vol) {
		
		this.number = number;
		this.name = name;
		this.value = value;
		this.count = count;
		this.vol = vol;
	}
	
	public int getSerialNum() {
		return number;
	}
	
	public String toString() {
		return "Refrigerator number=" + number + ", name=" + name + ", value=" + value + ", count=" + count
				+ ", vol=" + vol;
	}
	public void setSerialNum(int serialNum) {
		this.number = serialNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCost() {
		return value;
	}
	public void setCost(int cost) {
		this.value = cost;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getVol() {
		return vol;
	}
	public void setVol(int vol) {
		this.vol = vol;
	}
}
