package com.cabinvoice;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

import org.junit.Test;

public class InvoiceGenretorTest {


	InvoiceGenerator invoiceGenerator;

	@Before
	public void init() {
		invoiceGenerator = new InvoiceGenerator();
	}

	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 1.0;
		int time = 10;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(20, fare, 0.0);
	}
	@Test
	public void givenDistanceAndTime_WhenTotalFareLessThan10_ShouldReturnMinimumFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(5, fare, 0.0);
	}

	@Test
	public void givenMultipleRidesShouldReturnTotalFare() {
		MultipalRides[] rides = { new MultipalRides(2.0, 5), new MultipalRides(0.1, 1) };
		double fare = invoiceGenerator.calculateFare(rides);
		assertEquals(30, fare, 0.0);
	}
}