package com.bridgelabz.qa.datadrivrnframework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class FbLoginExcel {
	WebDriver driver;

	@Test(dataProvider = "wordpressData")
	public void loginToFb(String username, String password) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\AZ\\eclipse-workspace\\CQA_113_SELENIUM_AUTOMATION\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/login/");
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.name("pass")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getTitle().contains("Facebook"),
				"USer is not able to login -Invalid credintial");
		System.out.println("Page title verified - ");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@DataProvider(name = "wordpressData")
	public Object[][] passData() {
		ExcelDataConfig config = new ExcelDataConfig("C:\\Users\\AZ\\eclipse-workspace\\DataDriven_Framework\\src\\main\\resources\\InputData.xlsx");
		int rows = config.getrowCount(0);
		Object[][] data = new Object[rows][2];
		for (int i = 0; i < rows; i++) {
			data[i][0] = config.getData(0, i, 0);
			data[i][1] = config.getData(0, i, 1);
		}

		return data;

	}

}
