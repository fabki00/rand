package com.whitestratus.stratusphere;

import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;





public class LoginTest {
	static WebDriver driver;
	final private String PROTOCOL = "https";
	final private String DOMAIN  = "stratusphere-uat.appspot.com";
	final private String BASE_URL = PROTOCOL +"://" + DOMAIN;
	
	final private String invalidUserid = "test.user.ws.01@gmail.com";
	final private String invalidUserIdPassword = "el3phant";
	
	final private String validUserid01 = "test.user@dev.whitestratus.com";
	final private String validUserid01Password = "Oh snap, temp 7.";
	
	final private String validUserid02 = "selenium-1@dev.bg-corporation.com";
	final private String validUserid02Password ="39lS6Wi^Fz5q";
	
	@Before
	public void setUp() { 
		
		System.out.println("========== Start of Test =============");
		
		driver = new FirefoxDriver();
		driver.get(BASE_URL);
		
	}
	
	@Test 
	public void loginInvalidUser() {
		// this user should not be allowed to log in 
		
		WebElement emailId = driver.findElement(By.id("Email"));
		emailId.sendKeys(invalidUserid);
		WebElement pass 	= driver.findElement(By.id("Passwd"));
		pass.sendKeys(invalidUserIdPassword);
		WebElement staySignedIn = driver.findElement(By.id("PersistentCookie"));
		if  ( staySignedIn.isSelected() )  {
			staySignedIn.click();;
		}
		
		
		WebElement signIn = driver.findElement(By.id("signIn"));
		signIn.click();
		
	//	WebDriverWait wait = new WebDriverWait(driver, 4);	
		
		assertTrue("Should not log in", driver.getTitle().startsWith("Google Accounts"));
		
	}
	
	@Test
	public void loginValidUserId01() {
		// this user should be able to log in 
		
		WebElement emailId = driver.findElement(By.id("Email"));
		emailId.sendKeys(validUserid01);
		WebElement pass 	= driver.findElement(By.id("Passwd"));
		pass.sendKeys(validUserid01Password);
		WebElement staySignedIn = driver.findElement(By.id("PersistentCookie"));
		if  ( staySignedIn.isSelected() )  {
			staySignedIn.click();;
		}
		WebElement signIn = driver.findElement(By.id("signIn"));
		signIn.click();
		
	//	WebDriverWait wait = new WebDriverWait(driver, 4);
		
		assertTrue("Logged in", driver.getTitle().startsWith("WS Search App"));
		
		
	}
	
	@Test
	public void loginValidUserId02() {
		
		WebElement emailId = driver.findElement(By.id("Email"));
		emailId.sendKeys(validUserid02);
		WebElement pass 	= driver.findElement(By.id("Passwd"));
		pass.sendKeys(validUserid02Password);
		WebElement staySignedIn = driver.findElement(By.id("PersistentCookie"));
		if  ( staySignedIn.isSelected() )  {
			staySignedIn.click();;
		}
		WebElement signIn = driver.findElement(By.id("signIn"));
		signIn.click();
		
	//	WebDriverWait wait = new WebDriverWait(driver, 4);
		
		String title = driver.getTitle();
		System.out.println("Current title is : "+ title);
		
		assertTrue("Not logged in", driver.getTitle().startsWith("WS Search App"));
		
	}
	
	@After 
	public void tearDown() {
		driver.close();
		driver.quit();
		System.out.println("============= End of Test ==============");
	}
	
	
}
