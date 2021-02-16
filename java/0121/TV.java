package com.ssafy.algo;

public class TV {
	
	private int Number;
	private String name;
	private int value;
	private int count;
	private int inch;
	private String display_type;
	
	public TV(int number, String name, int cost, int count, int inch, String display_type) {
		
		this.Number = Number;
		this.name = name;
		this.value = value;
		this.count = count;
		this.inch = inch;
		this.display_type = display_type;
	}
	
	public String toString() {
		return "TV Number=" + Number + ", name=" + name + ", value=" + value + ", count=" + count + ", inch="
				+ inch + ", display_type=" + display_type ;
	}
	public int getNumber() {
		return Number;
	}
	public void setNumber(int number) {
		Number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getInch() {
		return inch;
	}
	public void setInch(int inch) {
		this.inch = inch;
	}
	public String getDisplay_type() {
		return display_type;
	}
	public void setDisplay_type(String display_type) {
		this.display_type = display_type;
	}
	
	
}
