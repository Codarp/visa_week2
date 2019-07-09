package com.visa.prj.entity;

public class Time {
	
	private int hours;
	private int min;
	
	public Time(int hours, int min) {
		this.hours = hours;
		this.min = min;
	}
	
	public static Time addTime(Time t1, Time t2) {
		
		int hours = t1.getHours()+t2.getHours();
		int min = t1.getMin() + t2.getMin();
		if (min >= 60) {
			hours++;
			min-=60;
		}
			
		Time intermediary = new Time(hours, min);
		return intermediary;
	}
	
	public Time addTime(Time t1) {
		return Time.addTime(this, t1);
	}
	
	public int getHours() {
		return this.hours;
	}
	
	public int getMin() {
		return this.min;
	}
}
