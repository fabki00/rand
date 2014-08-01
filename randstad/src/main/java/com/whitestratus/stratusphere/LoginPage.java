package com.whitestratus.stratusphere;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;

//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.Wait;


public class LoginPage extends PageBase {
	 // private String PROTOCOL;
	 // private String DOMAIN ;
	 // private String BASE_URL;
	 
	// WebDriver is defined in superclass PageBase
	// private final WebDriver driver; 
	
	//define locators for page elements
	By emailLocator = By.id("Email");
	By passwordLocator = By.id("Passwd");
	By signInLocator = By.id("signIn");
	By rememberLocator = By.id("PersistentCookie");
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;	
		
		// check that we are on the login page
		if (!driver.getTitle().equals("Sign in - Google Accounts")) {			
			throw new IllegalStateException("This is not a login page");
		}
		
		
	//	Wait wait = new FluentWait(driver).withTimeout(30, SECONDS).pollingEvery(2, SECONDS);		
	//    wait.until(ExpectedConditions.titleIs("Login"));
		
	}
	
	
	
	public void get(String url) {
		driver.get(url);
	}
	
	// public LoginPage enterEmail(String email) 
	public void enterEmail(String email){
		driver.findElement(emailLocator).sendKeys(email);
	//	return this;
	}	
	
//	public LoginPage enterPassword(String password) 
	public void enterPassword(String password){
		driver.findElement(passwordLocator).sendKeys(password);
	//	return this;
	}
	
	public void unckeckStaySignedIn() {
		WebElement stay = driver.findElement(rememberLocator);
		if (stay.isSelected() ) {
			stay.click();
		}
	}
	
	public PageBase signIn() {
		driver.findElement(signInLocator).click(); 
		return new PageBase(driver);
	}

		

}
