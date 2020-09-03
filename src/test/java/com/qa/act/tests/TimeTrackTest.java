package com.qa.act.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.act.base.TestBase;
import com.qa.act.pages.AddNewUser;
import com.qa.act.pages.HomePage;
import com.qa.act.pages.LoginPage;
import com.qa.act.pages.TimeTrack;

public class TimeTrackTest extends TestBase{
	LoginPage lp;
	HomePage hp;
	AddNewUser nu;
	TimeTrack tt;

	public TimeTrackTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		lp=new LoginPage();
		hp=new HomePage();
		nu=new AddNewUser();
		tt=new TimeTrack();
		hp=lp.Login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test
	public void validateTimeTrackTest() throws InterruptedException{
	   tt.validateMeeting();
	}
	
	@AfterMethod
	public void endUp() {
		driver.quit();
	}
}
