package com.qa.act.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.act.base.TestBase;
import com.qa.act.pages.AddNewUser;
import com.qa.act.pages.HomePage;
import com.qa.act.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage lp;
	HomePage hp;
	AddNewUser nu;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialization();
		lp=new LoginPage();
		hp=new HomePage();
		nu=new AddNewUser();
		hp=lp.Login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test
	public void SettingsTest() throws InterruptedException, IOException {
		takeScreenshot("Imagebefore");
		Thread.sleep(5000);
		hp.validateSettings();
		Thread.sleep(5000);
		takeScreenshot("ImageAfter");
	}
	
	
	@Test
	public void clickNewUserLinkTest() throws InterruptedException {
		nu=hp.verifyNewUserlink();
	}
	
	@AfterMethod
	public void endUp() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
