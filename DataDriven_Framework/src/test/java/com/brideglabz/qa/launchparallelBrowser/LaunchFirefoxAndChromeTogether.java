package com.brideglabz.qa.launchparallelBrowser;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchFirefoxAndChromeTogether {

		WebDriver driver=null;
		//String projectPath=System.getProperty("user.dir");
		@Parameters({"browserName"})
		@BeforeTest
		public void loginFFandCHROME( String browserName) throws InterruptedException, IOException{
			System.out.println("browser Name is "+browserName);
		
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			
		} else if (browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		}
		}
		
		@Test
		public void test() throws InterruptedException {
			driver.get("https://www.facebook.com/login/");
		Thread.sleep(4000);
		}
		
		@AfterTest
		public void teardown(){
		driver.close();
		System.out.println("test success");
		}
}

