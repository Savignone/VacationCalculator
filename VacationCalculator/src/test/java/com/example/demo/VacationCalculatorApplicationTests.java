package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.VacationService;


@SpringBootTest
class VacationCalculatorApplicationTests {
	
	private static final int VACATION_DAYS = 5;
	private static final double AVERAGE_SALARY = 25000;

	@Test
	public void testCalculatePayWithDates() {
        VacationService vacationService = new VacationService();
        
        String startDate = "2024-04-01"; 
        String endDate = "2024-04-07"; 

        double expectedPay = Math.round((AVERAGE_SALARY / 29 * VACATION_DAYS) * 100) / 100; 
        
        assertEquals(expectedPay, vacationService.calculatePayWithDates(AVERAGE_SALARY, VACATION_DAYS, startDate, endDate), 10);
    }
	
	@Test
    public void testCalculatePay() {
        VacationService vacationService = new VacationService();

        double expectedPay = Math.round((AVERAGE_SALARY / 29 * VACATION_DAYS) * 100) / 100;

        assertEquals(expectedPay, vacationService.calculatePay(AVERAGE_SALARY, VACATION_DAYS), 10);
    }
	
}
