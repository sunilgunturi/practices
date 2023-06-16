package com.practices.snippetValidations;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JiraTicketCreation {
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
	public static WebElement findingByName(String Name) {
		WebElement NameField = driver.findElement(By.name(Name));
		return(NameField);
	}
	
	public static void waitToAction(int timeInSeconds) throws InterruptedException {
		Thread.sleep(timeInSeconds*1000);
	}
	
	public static void main(String[] args) throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("https://keenhealth.atlassian.net");
		waitToAction(2);
		findingByID("google-auth-button").click();
		findingByID("identifierId").sendKeys("sunil.gunturi@choosekeen.com");
		waitToAction(2);
		findingByXpath("//span[text()='Next']").click();
		waitToAction(2);
//		findingByName("password").sendKeys("ChooseKeen@2023");
		findingByXpath("//input[@type='password']").sendKeys("ChooseKeen@2023");
//		findingByXpath("//input[contains(@name,'pass')]").sendKeys("ChooseKeen@2023");
		waitToAction(2);
		findingByXpath("//span[text()='Next']").click();
		waitToAction(40);
//		findingByID("createGlobalItem").click();
		waitToAction(10);
		findingByXpath("//p[text()='Eng']").click();
	int[] countJIRAids = new int[]{3569,3640,3852};
	int totalNumberOfJIRAids = countJIRAids.length;
	int NextTicket=0;
	for(int[] JiraID=countJIRAids;NextTicket<=totalNumberOfJIRAids;NextTicket++) {
		String JIRAidToOpen = "https://keenhealth.atlassian.net/browse/EN-"+JiraID[NextTicket];
		System.out.println("Opening the URL: "+JIRAidToOpen);
		driver.get(JIRAidToOpen);
		System.out.println("Successfully Opened the ticket = EN-"+JiraID);
		
		}
	}
	
}
