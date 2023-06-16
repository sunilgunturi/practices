package com.practices.snippetValidations;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.LocalDate;
import java.time.Month;
import java.text.ParseException;
import java.text.SimpleDateFormat;  

public class TimsheetSubmissionsDaily 
{	
	public static WebDriver driver = new ChromeDriver();

	public static WebElement findingByXpath(String xPathValue) {
		WebElement xPathField = driver.findElement(By.xpath(xPathValue));
		return(xPathField);
	}
	public static WebElement findingByID(String IDValue) {
		WebElement xPathField = driver.findElement(By.id(IDValue));
		return(xPathField);
	}
	public static WebElement findingByLinkText(String LinkTextValue) {
		WebElement LinkTextField = driver.findElement(By.linkText(LinkTextValue));
		return(LinkTextField);
	}
	public static WebElement findingByClass(String ClassName) {
		WebElement ClassNameField = driver.findElement(By.linkText(ClassName));
		return(ClassNameField);
	}
	public static void waitToAction(int timeInSeconds) throws InterruptedException {
		Thread.sleep(timeInSeconds*1000);
	}
	public static void main( String[] args ) throws ParseException, java.text.ParseException, InterruptedException {
// --> Launching Browser and opening the Timesheet in MySpace.
		ChromeOptions options=new ChromeOptions();
//		options.addArguments("--headless");
//		options.addArguments("headless");
		driver=new ChromeDriver(options);
		driver.get("https://myspace.innominds.com/user/login");
		waitToAction(2);
		String ReadHomePageContentChar = findingByXpath("/html[1]/body[1]/div[2]/ul[1]/li[1]/div[2]/div[1]/div[1]/div[1]/div[1]").getText();
		System.out.println("Content from Home Page is: "+ReadHomePageContentChar);
		String[] numbers = ReadHomePageContentChar.split(" ");
	    System.out.println(numbers[1]+" is the Date captured into String");
	    int captureddate = Integer.parseInt(numbers[1]);
		findingByID("username").sendKeys("sgunturi");
		findingByID("password").sendKeys("Waverock@2022");
		waitToAction(2);
		findingByID("submit").click();
		System.out.println("User Logged in Successfully");
		waitToAction(2);
		findingByLinkText("Time Sheets").click();
		System.out.println("Navigated to Timesheets page.");
		waitToAction(2);	
// --> Framing the date for URL to launch.
    	int dateCounter;
		String dateToString, datesToLogTime,monthValueConversion;
        LocalDate currentdate = LocalDate.now();
        int monthValue = currentdate.getMonthValue();
        Month monthName = currentdate.getMonth();
        int yearValue = currentdate.getYear();
// --> Total Number of days in Month finder.        
        if (monthValue==2) dateCounter = 28;
		else if((monthValue==4)||(monthValue==6)||(monthValue==9)||(monthValue==11)) dateCounter = 30;
		else dateCounter = 31;
        System.out.println("");
        System.out.printf("Total Number of days in the month = "+dateCounter);
        System.out.println("");
// --> Month Numeric finder for two digit framing        
	    if (monthValue<=9)  monthValueConversion="0"+String.valueOf(monthValue);
		else monthValueConversion=String.valueOf(monthValue);
// --> Preparing the loop to frame the URL for everyday timesheet launch.
	    
	    
	    if(!driver.getPageSource().contains("Attendance Alert:")) {
	    	System.out.println("Attendance filled already!!");
	    	driver.quit();
	    }
	    else {
		for(int datesToClick=1; datesToClick<=captureddate; datesToClick++) {            // for filling the monthly timesheet.
//		for(int datesToClick=captureddate; datesToClick<=captureddate; datesToClick++) {    // for filling the timesheet today.
			dateToString = datesToClick+"-"+monthName+"-"+yearValue;
		    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyyy");  //For converting the string to date.
	        SimpleDateFormat formatter = new SimpleDateFormat("E");  //For converting the date to Day Name of the week.
	        Date dateToOpen = dateFormatter.parse(dateToString);
	        String WeekNameOfDate = formatter.format(dateToOpen);
	        if(WeekNameOfDate.equals("Sat") || WeekNameOfDate.equals("Sun")) {
				if(datesToClick<=9)
					System.out.println("SKIPPED DATE IS : "+yearValue+"-"+monthValueConversion+"-0"+datesToClick+" - "+WeekNameOfDate);
				else 
					System.out.println("SKIPPED DATE IS : "+yearValue+"-"+monthValueConversion+"-"+datesToClick+" - "+WeekNameOfDate);
			}
			else {
				if(datesToClick<=9)
					datesToLogTime = "https://myspace.innominds.com/Employee/timesheet?reqdate="+yearValue+"-"+monthValueConversion+"-0"+datesToClick;
				else 
					datesToLogTime = "https://myspace.innominds.com/Employee/timesheet?reqdate="+yearValue+"-"+monthValueConversion+"-"+datesToClick;
// --> Launching the everyday using the URL.
				driver.get(datesToLogTime);
//				System.out.println("Opened the date: "+datesToLogTime);
				System.out.println("");
// --> Launching the Today's Date page and filling the time.
				String date = yearValue+"-0"+monthValue+"-"+datesToClick;
					waitToAction(2);
/*					
// --> Adding time to First Project.
					findingByID("hours_1859_150").clear();
					findingByID("hours_1859_150").sendKeys("1");
					findingByID("notes_1859_150").clear();
					findingByID("notes_1859_150").sendKeys("Daily Stand up Meeting");
					findingByID("hours_1859_268").clear();
					findingByID("hours_1859_268").sendKeys("7");
					findingByID("notes_1859_268").clear();
					findingByID("notes_1859_268").sendKeys("Testing the Sprint Tickets");
					System.out.println("Added the Time for Project 1 - Ainsley for "+date);
// --> Expanding the Second Project.					
					findingByXpath("(//div[@class='time-text left'])[2]").click();
*/
// --> Adding time to Second Project.
					waitToAction(2);
					findingByID("hours_1878_18").clear();
					findingByID("hours_1878_18").sendKeys("8");
					findingByID("notes_1878_18").clear();
					findingByID("notes_1878_18").sendKeys("Standup and Testing the SFDC application");
					System.out.println("Added Time for "+date);
					findingByID("sub").click();
					System.out.println("Submitted the Timesheet for "+yearValue+"-0"+monthValue+"-"+datesToClick); 
				}
	       }
		System.out.println("End of Execution using Automation");
		driver.quit();
	    }
	}
}