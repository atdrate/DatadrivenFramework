package com.bridgelabz.qa.POM.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bridgelabz.qa.POM.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//span[contains(text(),'Subodh Nagalwade')]")
	WebElement userNameLabel;

	@FindBy(xpath = "//span[contains(text(),'Friends')]")
	WebElement friendList;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatieHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public FriendPage clickOnFriendList() {
		friendList.click();
		return new FriendPage();
	}
}
