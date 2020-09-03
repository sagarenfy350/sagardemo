package com.qa.act.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.qa.act.base.TestBase;

public class AddNewUser extends TestBase{
	
	@FindBy(xpath="(//input[@name='firstName'])[2]")
	WebElement firstname;
	
	@FindBy(xpath="(//input[@name='lastName'])[2]")
	WebElement lastname;
	
	@FindBy(xpath="(//input[@name='email'])[2]")
	WebElement emailid;
	
	@FindBy(xpath="(//div[@class='selectorPlaceholder'])[2]/div") 
	WebElement downicon;
	
	@FindBy(xpath="//div[@class='itemsContainer']/div[5]")
	WebElement quality;
	
	@FindBy(xpath="(//td[@class='x-btn-right'])[4]")
	WebElement calclick;
	 
	@FindBy(xpath="(//div[@class='components_button_label'])[4]")
	WebElement save;
	
	@FindBy(xpath="(//div[@class='closeLink'])[1]/span")
	WebElement close;
	
	@FindBy(xpath="//a[@class='content tt']")
	WebElement timeclick;
	
	public AddNewUser() {
		PageFactory.initElements(driver,this);
	}
	
	public void validateNewUser(String firstName,String lastName,String eMail) throws InterruptedException {
		  
		  firstname.sendKeys(firstName);
		  Thread.sleep(2000);
		
		  lastname.sendKeys(lastName); 
		  Thread.sleep(2000);
		  
		  emailid.sendKeys(eMail); 
		  Thread.sleep(2000);
		  
		  System.out.println("I have executed till Email field");
		  
		  downicon.click();
		  
		  quality.click();
		  
		  System.out.println("I have selected dropdown");
		  
		  JavascriptExecutor js=(JavascriptExecutor)driver;
			 
		  js.executeScript("arguments[0].click();", calclick);
	      System.out.println("I found the calendar"); 
	      Thread.sleep(10000);
			
		  js.executeScript("document.getElementById('ext-gen610').value='Jan01,2020'"); 
		  Thread.sleep(10000);
			 
	      save.click();
		  Thread.sleep(5000);
		  
		  close.click();
		  Thread.sleep(3000);
		   
		  timeclick.click();
		  Thread.sleep(3000);
	}
	
}
