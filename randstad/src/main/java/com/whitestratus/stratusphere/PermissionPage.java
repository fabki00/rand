package com.whitestratus.stratusphere;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PermissionPage extends PageBase {
	
	//define locators for page elements
	By approveButtonLocator = By.id("approve_button");
	By allowLocator = By.name("submit_ture");
	By noThanksLocator = By.name("submit_false");
	By rememberLocator = By.id("persist_checkbox");


	
	public PermissionPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
		// check that we are on the permissions page
		if (!driver.getTitle().equals("Google Accounts")) {			
			throw new IllegalStateException("This is not the permissions page");
		}		
	}
	
	public void clickAllow() {
		WebElement allow = driver.findElement(allowLocator);
		allow.click();
	}

	public void clickNoThanks() {
		WebElement notAllow = driver.findElement(noThanksLocator);
		notAllow.click();
	}
	
	public void clickRemember() {
		WebElement remember = driver.findElement(rememberLocator);
		remember.click();
	}
	
	public void signAnotherAccount(){
		// TODO
	}
}
