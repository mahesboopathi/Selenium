package com.auomation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.SessionId;

public class BrowserHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		System.setProperty("webdriver.chrome.driver", "M:\\Learn-Automation\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com");
		SessionId session = ((ChromeDriver) driver).getSessionId();
		System.out.println("Session Id is :" + session);
		// driver.manage().window().maximize();
		Dimension dim = new Dimension(1000, 800);
		driver.manage().window().setSize(dim);
		String title = driver.getTitle();

		System.out.println("Title of the page is:" + title);
		if (title.equals("Google")) {
			System.out.println("Test pass");
		} else {
			System.out.println("Test fail");
		}
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("google");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('style', 'background: red; ');", search);
		// driver.close();

	}

}
