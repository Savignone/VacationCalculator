package com.example.demo.utility;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Utility {

	public static final Set<LocalDate> holidays = new HashSet<>();
    static {
        holidays.add(LocalDate.of(2024, 1, 1)); 
        holidays.add(LocalDate.of(2024, 1, 2)); 
        holidays.add(LocalDate.of(2024, 1, 3)); 
        holidays.add(LocalDate.of(2024, 1, 4)); 
        holidays.add(LocalDate.of(2024, 3, 8)); 
    }
    

    public static boolean isWorkingDay(LocalDate date) {
	    
	    if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
	        return false;
	    }

	    if (isHoliday(date)) { 
	        return false;
	    }

	    return true;
	}
    
    public static boolean isHoliday(LocalDate date) {// Проверка на выходной
	    
		return holidays.contains(date);
	}
}
