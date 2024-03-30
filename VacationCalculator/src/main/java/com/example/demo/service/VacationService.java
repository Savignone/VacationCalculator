package com.example.demo.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import com.example.demo.utility.*;

@Service
public class VacationService {

	public double calculatePayWithDates(double averageSalary, int vacationDays, String startDate, String endDate) {
		
		LocalDate start = LocalDate.parse(startDate);
		LocalDate end = LocalDate.parse(endDate);
		
		double dailyPay = averageSalary / 29;
		
		int workingDays = 0; // Количество найденных рабочих дней
		
		for (LocalDate date = start; date.isBefore(end.plusDays(1)); date = date.plusDays(1)) {
			if(Utility.isWorkingDay(date)) {
				workingDays++;
			}
		    
		}
		return dailyPay * workingDays;
	}
	

	public double calculatePay(double averageSalary, int vacationDays) {
		
		double dailyPay = averageSalary / 29;
		
		return dailyPay * vacationDays;
	}
	
}
