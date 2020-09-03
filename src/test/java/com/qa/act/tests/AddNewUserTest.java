package com.qa.act.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.act.base.TestBase;
import com.qa.act.pages.AddNewUser;
import com.qa.act.pages.HomePage;
import com.qa.act.pages.LoginPage;
import com.qa.act.pages.TimeTrack;

public class AddNewUserTest extends TestBase{
	LoginPage lp;
	HomePage hp;
	AddNewUser nu;
	
	public AddNewUserTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException { 
		initialization();
		lp=new LoginPage();
		hp=new HomePage();
		nu=new AddNewUser();
		hp=lp.Login(prop.getProperty("username"),prop.getProperty("password"));
		nu=hp.verifyNewUserlink();
	}
	
	@Test
	public TimeTrack validateNewUserTest() throws InterruptedException {
		nu.validateNewUser(prop.getProperty("firstname"),prop.getProperty("lastname"),prop.getProperty("email"));
	    return new TimeTrack();
	}
	
	@AfterMethod
	public void endUp() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}

}
