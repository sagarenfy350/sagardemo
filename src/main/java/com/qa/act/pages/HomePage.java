package com.qa.act.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.act.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//a[@class='content users']")
	WebElement userslink;
	
	@FindBy(xpath="(//div[@class='components_button_label'])[1]")
	WebElement addnewuser;
	
	@FindBy(xpath="(//div[@class='popup_menu_icon'])[2]/div")
	WebElement settings;
	
	@FindBy(xpath="(//a[@class='item_link'])[8]")
	WebElement logosettings;
	
	@FindBy(xpath="//input[@id='uploadNewLogoOption']")
	WebElement radiocust;
	
	@FindBy(xpath="//input[@name='formCustomInterfaceLogo.logo']")
	WebElement choosefile;
	
	@FindBy(xpath="//input[@class='saveButton']")
	WebElement save1;
	
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	public void validateSettings() throws InterruptedException, IOException {
		settings.click();
		Thread.sleep(2000);
		
		logosettings.click();
		Thread.sleep(2000);
		
		radiocust.click();
		Thread.sleep(2000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		 
		js.executeScript("arguments[0].click();",choosefile );
		Thread.sleep(2000);
		
        Runtime.getRuntime().exec("C:\\Users\\Vidhya Sagar\\Documents\\autoit\\logofile.exe");
        Thread.sleep(2000);
        
        save1.click();
        Thread.sleep(2000);
        
	}
	
	public AddNewUser verifyNewUserlink() throws InterruptedException {
		userslink.click();
		Thread.sleep(3000);
		addnewuser.click();
		return new AddNewUser();
	}
	
	
	

}
