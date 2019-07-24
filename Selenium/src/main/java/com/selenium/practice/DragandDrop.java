package com.selenium.practice;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.Utils;

public class DragandDrop {
	WebDriver driver;

	@BeforeTest
	public void setup() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		System.setProperty("webdriver.chrome.driver", "M:\\Learn-Automation\\Selenium\\Drivers\\chromedriver.exe");

		driver = new ChromeDriver(options);

	}

	@Test(priority = 0)
	public void dragdrop() throws InterruptedException {
		driver.get("https://jqueryui.com/");
		// Dimension dim = new Dimension(1000, 1800);
		// driver.manage().window().setSize(dim);
		driver.manage().window().maximize();
		Actions act = new Actions(driver);
		WebElement dropable = driver.findElement(By.linkText("Droppable"));
		dropable.click();
		Thread.sleep(3000);
		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);
		WebElement drag = driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
		WebElement drop = driver.findElement(By.xpath("//div[@id=\"droppable\"]"));
		act.dragAndDrop(drag, drop).build().perform();

		driver.switchTo().defaultContent();
		Thread.sleep(2000);

	}

	@Test(priority = 1)

	public void clickSubmenu() {
		WebElement theme = driver.findElement(By.linkText("Themes"));
		theme.click();
		WebElement fontset = driver.findElement(By.linkText("Font Settings"));
		fontset.click();
		WebElement weight = driver.findElement(By.xpath("//select[@name=\"fwDefault\"]"));
		weight.click();
	}

	@AfterMethod
	public void failedScreenshot(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				TakesScreenshot screenshot = (TakesScreenshot) driver;
				File src = screenshot.getScreenshotAs(OutputType.FILE);
				Utils.copyFile(src, new File("M:\\Learn-Automation\\Selenium\\Screenshots\\failed.png"));
			} catch (Exception e) {
				System.out.println("Exception message is :" + e.getMessage());
			}
		}
		driver.close();

	}
}
