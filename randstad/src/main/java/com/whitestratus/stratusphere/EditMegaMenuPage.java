package com.whitestratus.stratusphere;

// this is main page for editing MegaMenu. It contains Site Panel, Menu Panel and Header (with Home button etc. )
// Services/methods supplied by this page are:
// choose Site
// saveChanges / cancel
// choose/add/remove Menu
// choose/add/remove Tab
// choose/add/ remove TabSection
// choose/add/remove MenuItem 
// testcases can then choose various combinations of the above elements as long as it's performed in correct order
// i.e. you can't choose MenuItem before choosing TabSection etc. 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;

import static  org.junit.Assert.*;

// check if LoadableComponent is really necessary here (maybe it's only needed for Ajax pages ) 

// public class EditMegaMenuPage extends LoadableComponent<EditMegaMenuPage>{
//public class EditMegaMenu extends PageBase {
public class EditMegaMenuPage {
	
	WebDriver driver;
	String baseURL = "https://ws-am-runtime.appspot.com/sitecontentmanagement_prototype_dev";
	MenuHeader  menu;	
	
	public enum Site {
		AUSTRALIA(1), CHINA(2), MALAYSIA(3), NEW_ZEALAND(4), SINGAPORE(5);
		private int dropDownValue;
		
		Site(int value){
			this.dropDownValue = value;
		}
		
		public int value() {
			return dropDownValue;
		}
	}
	
	public EditMegaMenuPage (WebDriver webDriver){
		driver = webDriver;
		driver.get(baseURL + "#EditMegaMenu");
	    //assertEquals("user is on search page: ", driver.getCurrentUrl(), "http://driven-fragment-509.appspot.com/#/home");
	    assertEquals("User is on Edit Mega Menu page",driver.findElement(By.id("gwt-debug-EditMegaMenu_HeaderLabel")).getText(),"Mega-Menu Editor" );
		
		// to check if we are on the right page verify presence of this element: gwt-debug-EditMegaMenu_HeaderLabel
	}
	
/*	@Override
	protected void load() {
		driver.get("https://ws-am-runtime.appspot.com/sitecontentmanagement_prototype_dev#EditMegaMenu");
	}
	
	@Override
	protected void isLoaded() throws Error {
		
	//	try driver.findElement(By.id(id))
		
	}
*/	
	public void chooseSite(String site) {
		Select  siteSelect = new Select(driver.findElement(By.id("gwt-debug-EditMegaMenu_SiteSelector-inner-select")));
		siteSelect.deselectAll();
		siteSelect.selectByValue(site);	
		
		// if the above doesn't work (because the button is hidden) try clicking this button and choose appropriate option:
		// gwt-debug-EditMegaMenu_SiteSelector-disclosure
	}
	
	public void saveChanges() {
		WebElement saveButton = driver.findElement(By.id("gwt-debug-EditMegaMenu_SaveButton"));
		saveButton.click();
	}
	
	public void cancelChanges() {
		WebElement cancelButton = driver.findElement(By.id("gwt-debug-EditMegaMenu_CancelButton"));
		cancelButton.click();
	}
	
	//  choose/add/remove Menu
	
	public void chooseMenu() {
		
	}
	
	
	

}
