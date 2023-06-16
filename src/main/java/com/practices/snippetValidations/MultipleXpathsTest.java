package com.practices.snippetValidations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleXpathsTest {

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
			// TODO Auto-generated method stub
			driver.manage().window().maximize();
			driver.get("https://www.abhibus.com");
			findingByXpath("//div[@class=\"form-group mb-0\"]//input[@id='source']").sendKeys("Hyd");
			waitToAction(10);
			findingByXpath("//li[@class='ui-menu-item'][1]").click();
			waitToAction(10);
			driver.quit();
			
	}

}
