package com.cabinvoice;
public class MultipalRides {

	private double distance;
	private int time;
	public RideCategories rideCategory;


//	public MultipalRides(double distance, int time) {
	public MultipalRides(RideCategories rideCategory,double distance, int time) {
		this.rideCategory = rideCategory;
		this.distance = distance;
		this.time = time;
	}
	
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
}