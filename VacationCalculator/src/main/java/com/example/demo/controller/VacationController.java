package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.VacationResponse;
import com.example.demo.service.VacationService;

@RestController
public class VacationController {
	
	@Autowired
	private VacationService vacationService;
	
	@GetMapping("/calculate")
	public VacationResponse calculateVacation(
	        @RequestParam(name = "averageSalary") double averageSalary,
	        @RequestParam(name = "vacationDays") int vacationDays,
	        @RequestParam(name = "startDate", required = false) String startDate,
	        @RequestParam(name = "endDate", required = false) String endDate) {
		
		double vacationPay; // переменная для хранения результата
	    
	    vacationPay = (startDate != null && endDate != null) ?  
	    		vacationService.calculatePayWithDates(averageSalary, vacationDays, startDate, endDate) : 
	    		vacationService.calculatePay(averageSalary, vacationDays);
	    
	    VacationResponse response = new VacationResponse();
	    response.setVacationPay(vacationPay);
	    return response;
	}
}
