package com.auomation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test
public class ValidateGooglepage {
	public void google() {
		System.setProperty("webdriver.chrome.driver", "M:\\Learn-Automation\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println(title);
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("mahes");
		
	}
}
