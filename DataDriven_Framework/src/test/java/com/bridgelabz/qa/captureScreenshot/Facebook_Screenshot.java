package com.bridgelabz.qa.captureScreenshot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook_Screenshot {
WebDriver driver;
	@Test
	public void captureScreenshot() throws InterruptedException{
		WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	   driver.findElement(By.id("emails")).sendKeys("learn ss");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(ITestResult.FAILURE==result.getStatus()) {
			Utility.captureScreenshot(driver,result.getName());
		}
		driver.quit();
	}
}
