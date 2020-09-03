package com.qa.act.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.act.base.TestBase;

public class TimeTrack extends TestBase{
	
	@FindBy(xpath="//input[@id='taskSearchControl_field']")
	WebElement timetext;
	
	@FindBy(xpath="//div[@data-taskid='136']")
	WebElement meetlink;
	
	@FindBy(xpath="(//div[@class='cellButton'])[2]")
	WebElement deadline;
	
	public TimeTrack() {
		PageFactory.initElements(driver,this);
	}
	
	public void validateMeeting() throws InterruptedException {
		
		timetext.click();
		Thread.sleep(2000);
		
		timetext.sendKeys("Meetings");
		Thread.sleep(2000);
		
		timetext.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		
		timetext.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		
		meetlink.click();
		Thread.sleep(5000);
		
		deadline.click();
		Thread.sleep(5000);
		
		
		
		
	}
}
