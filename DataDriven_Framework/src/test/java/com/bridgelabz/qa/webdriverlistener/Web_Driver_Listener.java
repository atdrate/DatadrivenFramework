package com.bridgelabz.qa.webdriverlistener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Web_Driver_Listener {
	@Test
	public void webdriver_listener_Test(){
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		EventFiringWebDriver event_driver = new EventFiringWebDriver(driver);
		My_Test_Listener testListener = new My_Test_Listener();
		event_driver.register(testListener);
		event_driver.get("https://www.facebook.com/login/");
		event_driver.manage().window().maximize();
		event_driver.findElement(By.id("wrongid")).click();
	}
}
