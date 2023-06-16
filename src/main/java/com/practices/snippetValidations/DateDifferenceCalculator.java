package com.practices.snippetValidations;

import java.time.*;   

public class DateDifferenceCalculator {

   
    // Create function for finding difference   
    static void find(LocalDate  first_date, LocalDate second_date)   
    {   
        // Get period between the first and the second date   
        Period difference = Period.between(first_date, second_date);   
        // Show date difference in years, months, and days   
        System.out.print("Difference between two dates is:\n");   
        System.out.printf( "%d years, %d months and %d days",   
            difference.getYears(),   
            difference.getMonths(),   
            difference.getDays());  
    }   
    // Main class  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // Create first and second date using LocalDate's of() method  
        LocalDate first_date = LocalDate.of(1997, 02, 15);   
        LocalDate second_date = LocalDate.now();   
        // Calling find() method to get and print the period between both dates   
        find(first_date, second_date);   

	}

} 