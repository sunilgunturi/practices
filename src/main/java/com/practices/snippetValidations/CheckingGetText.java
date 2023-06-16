package com.practices.snippetValidations;

import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckingGetText {	
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
			WebElement ClassNameField = driver.findElement(By.className(ClassName));
			return(ClassNameField);
		}	
		public static void waitToAction(int timeInSeconds) throws InterruptedException {
			Thread.sleep(timeInSeconds*1000);
		}
		
		public static void main( String[] args ) throws ParseException, java.text.ParseException, InterruptedException {
			driver.manage().window().maximize();
			driver.get("https://myspace.innominds.com/user/login");
			waitToAction(1);
			String ReadHomePageContentChar = findingByXpath("/html[1]/body[1]/div[2]/ul[1]/li[1]/div[2]/div[1]/div[1]/div[1]/div[1]").getText();
			System.out.println("Content from Home Page is: "+ReadHomePageContentChar);
			String[] numbers = ReadHomePageContentChar.split(" ");
		        System.out.println(numbers[1]);
		    System.out.println("============================================");
			findingByID("username").sendKeys("sgunturi");
			findingByID("password").sendKeys("innominds@123");
			waitToAction(1);
			findingByID("submit").click();
			System.out.println("User Logged in Successfully");
			waitToAction(1);
			findingByLinkText("Time Sheets").click();
			waitToAction(1);
			driver.quit();
		}
}
