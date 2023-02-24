package com.bridgelabz.qa.log4j;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenerateLogs {
	@Test
	public  void generate_Log() {
		Logger log = Logger.getLogger(GenerateLogs.class);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();	
		log.info("launching browser");	
		driver.get("https://www.facebook.com/login/");
		log.info("fb login page is launched");	
		String title = driver.getTitle();
		System.out.println("Title value is "+title);
		log.info("Title value is "+title);	
		if(title.equals("Log in to Facebook")) {
			System.out.println("correct title is Log in to Facebook");
			log.info("correct title is Log in to Facebook and test is passed");
		}
		else {
			System.out.println("title is not correct");
			log.info("correct title is  not Log in to Facebook and test is failed");
		}
		driver.quit();
	}
}
