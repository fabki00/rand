package com.whitestratus.stratusphere;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SiteContentMgmtTest {
	
	WebDriver driver = new FirefoxDriver();
	// TODO  Refactor LoginTest to create PageObject for Login site and use it to login and also to
	// create login tests  
	LoginPage loginPage = new LoginPage(driver);
	String email = "test.admin@dev.whitestratus.com";
	String password = "Oh snap, temp 7.";
	
	
	@Test 
	public void loginToSite() {
		loginPage.get("https://ws-am-runtime.appspot.com/sitecontentmanagement_prototype_dev");
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		loginPage.unckeckStaySignedIn();
		loginPage.signIn();
		// verify that we are on the right page
	}
	
	
	@Test
	public void testSettingSite() {
		
		// create new instance of the EditMegaMenu page
		EditMegaMenuPage editMegaMenuPage = new EditMegaMenuPage(driver);
		editMegaMenuPage.chooseSite("Australia");
		
	}
	
	@Test 
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
