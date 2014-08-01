package com.whitestratus.scmt;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/* 
 *  This is the superclass for all other Page classes that declares WebDriver.
 */

public class PageBase {
	protected String Url;
	protected WebDriver driver;
	protected String pageTitle; 	// expected page title; will be used to check if page is loaded
	
	// public PageBase(WebDriver driver, String pageTitle)  // TODO use expected page title or some other element on the page
	                                                        // to verify if page is loaded
	public PageBase(WebDriver driver){
		this.driver = driver;
	//	this.pageTitle = pageTitle;
		
	}
	
	public void open() {
		driver.get(Url);
	}
	
	public String getTitle() {		
		
		return this.pageTitle;
	}
	
	public void setTitle(String title){
		this.pageTitle = title;
	}
	
	public WebElement getWebElement(By id ) {
		WebElement el = null ;
		//TODO
		return el;	
	}
	
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;			
		}		
	}
	
	public boolean isTextPresent(String txt) {
		return driver.getPageSource().contains(txt);
	}

}
