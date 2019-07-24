package com.selenium.report;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.expectThrows;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.SessionId;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Report {
	ExtentReports report;
	ExtentTest logger;
	ExtentHtmlReporter htmlReporter;
	WebDriver driver;

	String path = "M:\\Learn-Automation\\Selenium\\Report\\report.html";

	@BeforeTest
	public void setUp() {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("Disable-infobars");

		htmlReporter = new ExtentHtmlReporter(path);
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		System.setProperty("webdriver.chrome.driver", "M:\\Learn-Automation\\Selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver(opt);

	}

	@Test
	public void VerifyTitle() {
		SessionId id = ((ChromeDriver) driver).getSessionId();
		System.out.println(id.toString());

		logger = report.createTest("Google title verify", "To test the google title in home page");
		driver.get("https://www.google.com/");
		logger.log(Status.INFO, "opend google website");
		assertEquals(driver.getTitle(), "Google");
		logger.log(Status.PASS, "Home page launched");

	}

	@Test

	public void search() {
		
			logger = report.createTest("To verify search", "To test the search title");
			WebElement srchBox = driver.findElement(By.name("q"));

			srchBox.sendKeys("mahes");
			logger.log(Status.INFO, "Search the input");
			srchBox.sendKeys(Keys.ENTER);

			assertEquals(driver.getTitle(), "Mahe");
			logger.log(Status.PASS, "Search found");
			

	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " Test case FAILED ", ExtentColor.YELLOW));

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " Test case PASSED ", ExtentColor.GREEN));

		}

	}

	@AfterTest
	public void testEnd() {
		report.flush();
	}

	@AfterClass

	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}

}
