package com.bridgelabz.qa.POM.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bridgelabz.qa.POM.base.TestBase;

public class LoginPage extends TestBase {
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="pass")
	WebElement password;
	
	@FindBy(name="login")
	WebElement loginButton;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatieLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login (String un, String pwd) {
		email.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		return new HomePage();
	}
}
