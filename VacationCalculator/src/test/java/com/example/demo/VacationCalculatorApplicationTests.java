package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.VacationService;


@SpringBootTest
class VacationCalculatorApplicationTests {

	@Test
	public void testCalculatePayWithDates() {
        VacationService vacationService = new VacationService();
        
        double averageSalary = 50000; 
        int vacationDays = 5; 
        String startDate = "2024-04-01"; 
        String endDate = "2024-04-07"; 

        double expectedPay = Math.round((50000 / 29 * 5) * 100) / 100; 
        
        assertEquals(expectedPay, vacationService.calculatePayWithDates(averageSalary, vacationDays, startDate, endDate), 10);
    }
	
	@Test
    public void testCalculatePay() {
        VacationService vacationService = new VacationService();
        
        double averageSalary = 3000; 
        int vacationDays = 5; 

        double expectedPay = Math.round((3000 / 29 * 5) * 100) / 100;

        assertEquals(expectedPay, vacationService.calculatePay(averageSalary, vacationDays), 10);
    }
	
}
