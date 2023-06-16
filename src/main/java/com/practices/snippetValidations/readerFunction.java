package com.practices.snippetValidations;

import java.util.Arrays;
import java.util.Scanner;

public class readerFunction {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner ReadTickets = new Scanner(System.in);
	    String[] TicketNumbers = ReadTickets.nextLine().split(",");
	    for (int Count=0; Count<TicketNumbers.length; Count++) {
	    	System.out.println(TicketNumbers[Count]);
	    }
	    System.out.println(Arrays.toString(TicketNumbers));
	   	}
   	}