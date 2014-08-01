package com.whitestratus.stratusphere;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class POLoginTest {
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
		driver = new FirefoxDriver();
		driver.get(BASE_URL);
		
	}
	
	@Test
	public void loginInvalidUser01() {
	//	LoginPage loginPage = new LoginPage(driver, "Site Content Management Tool - Version 1.0");
		LoginPage loginPage = new LoginPage(driver);
		System.out.println("=== Starting invalid user log in test ===");
		
		loginPage.enterEmail(invalidUserid);
		loginPage.enterPassword(invalidUserIdPassword);
		loginPage.unckeckStaySignedIn();
		String newTitle = loginPage.signIn().getTitle();
		
		System.out.println("Title is : " + newTitle);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		assertTrue("Should not log in ", newTitle.startsWith("Google Accounts"));
		
		//assertTrue("Should not log in", driver.getTitle().startsWith("Google Accounts"));		
		System.out.println("=== Ending invalid user log in test ===");
	}
	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
