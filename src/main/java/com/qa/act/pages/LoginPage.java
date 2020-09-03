package com.qa.act.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.act.base.TestBase;

public class LoginPage extends TestBase {
  @FindBy(name="username")
   WebElement username;
  
  @FindBy(name="pwd")
  WebElement password;
  
  @FindBy(xpath="//a[@id='loginButton']")
  WebElement login;
  
  public LoginPage() {
	  PageFactory.initElements(driver,this);
  }
  
  public HomePage Login(String user,String pass) {
	  
	  username.sendKeys(user);
	  password.sendKeys(pass);
	  login.click();
	  System.out.println("Logged in");
	  return new HomePage();
  }
  public void validateSettings() {
	  
  }
}
