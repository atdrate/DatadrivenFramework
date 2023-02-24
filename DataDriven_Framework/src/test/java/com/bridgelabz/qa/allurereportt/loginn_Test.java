package com.bridgelabz.qa.allurereportt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginn_Test {
	@Test
	public void listeners_Test(){
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/login/");
		driver.manage().window().maximize();
		String actualtitle = driver.getTitle();
		System.out.println("Current page title is: " + actualtitle);
		String expectedtittle = "Facebook – log in or sign up";
		System.out.println("expected page title is: " + expectedtittle);
		if (actualtitle.equals(expectedtittle)) {
			System.out.println("Tittle validation success");
		} else {
			System.out.println("Tittle validation failed");
		}
		driver.close();
	}
}
