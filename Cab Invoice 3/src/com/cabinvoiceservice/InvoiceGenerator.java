package com.cabinvoiceservice;

public class InvoiceGenerator {
	
	private static final int COST_PER_TIME = 1;
	private static final double COST_PER_KM = 10;
	private static final double MINIMUM_FARE = 5;
	
	public double calculateFare(double distance, int time) {
		return Math.max(MINIMUM_FARE, distance * COST_PER_KM + time * COST_PER_TIME);
	}
	
	public double calculateFare(MultipalRides[] rides) {
		double totalFare = 0;
		for (MultipalRides ride : rides) {
			totalFare += calculateFare(ride.getDistance(), ride.getTime());
		}
		return totalFare;
	}

	public EnhancedInvoice getInvoiceSummary(MultipalRides[] rides) {
		double totalFare = calculateFare(rides);
		int numOfRides = rides.length;
		return new EnhancedInvoice(numOfRides, totalFare);
	}
}