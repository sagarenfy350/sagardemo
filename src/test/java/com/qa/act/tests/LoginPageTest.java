package com.qa.act.tests;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.qa.act.base.TestBase;
import com.qa.act.pages.HomePage;
import com.qa.act.pages.LoginPage;

public class LoginPageTest extends TestBase{
LoginPage lp;
HomePage hp;

	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		lp=new LoginPage();
		hp=new HomePage();
	}
	
	@Test 
	public void validateLoginTest() throws InterruptedException {
		hp=lp.Login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test
	public void screenShotTest() throws IOException, InterruptedException {
	    takeScreenshot("Imageslogo");
	}
	
	
	
	@AfterMethod
	public void endUp() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}
