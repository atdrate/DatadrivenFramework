package com.bridgelabz.qa.POM.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bridgelabz.qa.POM.Page.FriendPage;
import com.bridgelabz.qa.POM.Page.HomePage;
import com.bridgelabz.qa.POM.Page.LoginPage;
import com.bridgelabz.qa.POM.base.TestBase;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	FriendPage friendPage;
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
    	loginPage = new LoginPage();
    	homePage =loginPage.login(prop.getProperty("email"),prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void homePageTitleTest(){
		String title = loginPage.validatieLoginPageTitle();
		Assert.assertEquals(title, "Facebook");
	}
	
	@Test(priority=2)
	public void verifyUSerNameTest(){
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyFriendPage(){
		friendPage=homePage.clickOnFriendList();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
