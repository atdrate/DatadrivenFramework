package com.bridgelabz.qa.POM.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bridgelabz.qa.POM.Page.FriendPage;
import com.bridgelabz.qa.POM.Page.HomePage;
import com.bridgelabz.qa.POM.Page.LoginPage;
import com.bridgelabz.qa.POM.base.TestBase;


public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	FriendPage friendPage;
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
    	loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validatieLoginPageTitle();
		Assert.assertEquals(title, "Facebook – log in or sign up");
	}
	
	@Test(priority=2)
	public void loginTest(){
		friendPage = homePage.clickOnFriendList();
	}
		
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
}
