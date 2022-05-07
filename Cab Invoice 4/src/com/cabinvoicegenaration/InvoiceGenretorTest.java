package com.cabinvoicegenaration;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class InvoiceGenretorTest {
	InvoiceGenerator invoiceService;

	@Before
	public void init() {
		invoiceService = new InvoiceGenerator();
	}

	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		double distance = 1.0;
		int time = 10;
		double fare = invoiceService.calculateFare(distance, time);
		assertEquals(20, fare, 0.0);
	}

	@Test
	public void givenDistanceAndTime_WhenTotalFareLessThan10_ShouldReturnMinimumFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceService.calculateFare(distance, time);
		assertEquals(5, fare, 0.0);
	}

	@Test
	public void givenMultipleRidesShouldReturnRideSummary() {
		MultipalRides[] rides = { new MultipalRides(2.0, 5), new MultipalRides(0.1, 1) };
		EnhancedInvoice summary = invoiceService.calculateFare(rides);
		EnhancedInvoice expectedSummary = new EnhancedInvoice(2, 30.0);
		assertEquals(expectedSummary, summary);
	}

	@Test
	public void givenUserIdShouldReturnTheInvoice() {
		String userId = "abc@123";
		MultipalRides[] rides = { new MultipalRides(2.0, 5), new MultipalRides(0.1, 1) };
		invoiceService.addRides(userId, rides);
		EnhancedInvoice summary = invoiceService.getInvoiceSummary(userId);
		EnhancedInvoice checkSummary = new EnhancedInvoice(2, 30.0);
		assertEquals(summary, checkSummary);
	}
}