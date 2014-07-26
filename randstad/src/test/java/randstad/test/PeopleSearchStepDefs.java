package randstad.test;

import java.util.*;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import cucumber.api.java.*;
import cucumber.api.java.en.*;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
//import cucumber.annotation.*;
//import cucumber.annotation.en.*;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


public class PeopleSearchStepDefs {
	static WebDriver driver;
	WebElement el;
	WebElement fName, lName, email, results;
	
	private List<User> expectedResults = new ArrayList<User>();
	public User expectedUser;
	private List<User> actualResults = new ArrayList<User>();
	
	
	@Before()  // this will run before every scenario
	public void setUp() {
		System.out.println("Before Scenario --- opening browser");
		//driver = new ChromeDriver();
		driver = new FirefoxDriver();
	}
	
	@Given("^user is on search page$")
	public void user_is_on_search_page()  throws Throwable{	
	    // assert that current URL is the search url
	//    assertEquals("user is on search page", driver.getCurrentUrl(), is(0));
	    assertEquals("user is on search page: ", driver.getCurrentUrl(), "http://driven-fragment-509.appspot.com/#/home");
		driver.get("http://driven-fragment-509.appspot.com/#/home");
		System.out.println("In user on search page");
	    
	}
	
	@Given("^user is regular user$")
	public void user_is_regular_user() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    //throw new PendingException();
	    // log in as regular user or admin or editor
	    // TODO needs to be changed to accept argument with type of user
	}
	
	@Given("^current default scope is \"([^\"]*)\"$")
	public void current_default_scope_is(String currentScope) throws Throwable {
	   
	    // if current default scope is not currentScope then make it currentScope
	    // make sure the other scopes are not chosen (selected)
	    
	    switch (currentScope) {
	    case "Document": // choose "Document" as default scope
	           if ( !driver.findElement(By.id("searchType_0")).isSelected() ) {
	               driver.findElement((By.id("searchType_0"))).sendKeys(Keys.SPACE);
	              
	           }
	           break;
	    case "People":
	        if ( !driver.findElement(By.id("searchType_1")).isSelected() ) {
                driver.findElement((By.id("searchType_1"))).sendKeys(Keys.SPACE);
            }
            break;
	    case "Site content":
            if ( !driver.findElement(By.id("searchType_2")).isSelected() ) {
                driver.findElement((By.id("searchType_2"))).sendKeys(Keys.SPACE);
            }
            break;   
            
	    }
	    
	    
	    switch(currentScope) {
	        case "Document":
	            assertTrue("current scope is " + currentScope, driver.findElement(By.id("searchType_0") ).isSelected());
	            assertFalse("current scope is not People", driver.findElement(By.id("searchType_1")).isSelected());
                assertFalse("current scope is not Site content", driver.findElement(By.id("searchType_2")).isSelected());
                break;
	        case "People":
	            assertTrue("current scope is " + currentScope, driver.findElement(By.id("searchType_1") ).isSelected());
                assertFalse("current scope is not Document", driver.findElement(By.id("searchType_0")).isSelected());
                assertFalse("current scope is not Site content", driver.findElement(By.id("searchType_2")).isSelected());
                break;
	        case "Site content":
                assertTrue("current scope is " + currentScope, driver.findElement(By.id("searchType_2") ).isSelected());
                assertFalse("current scope is not People", driver.findElement(By.id("searchType_1")).isSelected());
                assertFalse("current scope is not Document", driver.findElement(By.id("searchType_0")).isSelected());
	            

	    }
	    
	    
	}
	
	@When("^user chooses \"([^\"]*)\" as default scope$")
	public void user_chooses_as_default_scope(String newScope) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	   // throw new PendingException();
	    // choose newScope as default scope
	    
	    switch (newScope) {
	    case "Document":
	        driver.findElement(By.id("searchType_0")).sendKeys(Keys.SPACE);
	        break;
	    case "People":
	        driver.findElement(By.id("searchType_1")).sendKeys(Keys.SPACE);
	        break;
	    case "Site content":
	        driver.findElement(By.id("searchType_2")).sendKeys(Keys.SPACE);
	        break;
	    
	    }
	    
	}
	
	@Then("^new default scope is \"([^\"]*)\"$") 
	public void new_default_scope_is(String arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	    //
	}
	
	@Then("^new default scope \"([^\"]*)\" is saved accross browser sessions$")
	public void new_default_scope_is_saved_accross_browser_sessions(String newScope) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	   // throw new PendingException();
	    
	    // verify current default scope
	    switch( newScope) {
        case "Document":
            assertTrue("current scope is " + newScope, driver.findElement(By.id("searchType_0") ).isSelected());
            assertFalse("current scope is not People", driver.findElement(By.id("searchType_1")).isSelected());
            assertFalse("current scope is not Site content", driver.findElement(By.id("searchType_2")).isSelected());
            break;
        case "People":
            assertTrue("current scope is " + newScope, driver.findElement(By.id("searchType_1") ).isSelected());
            assertFalse("current scope is not Document", driver.findElement(By.id("searchType_0")).isSelected());
            assertFalse("current scope is not Site content", driver.findElement(By.id("searchType_2")).isSelected());
            break;
        case "Site content":
            assertTrue("current scope is " + newScope, driver.findElement(By.id("searchType_2") ).isSelected());
            assertFalse("current scope is not People", driver.findElement(By.id("searchType_1")).isSelected());
            assertFalse("current scope is not Document", driver.findElement(By.id("searchType_0")).isSelected());
         }

	    
	    // close the browser
	    driver.quit();
	    
	    // reopen browser
	       driver = new FirefoxDriver();
	       driver.get("http://driven-fragment-509.appspot.com/#/home");

	    
	    // verify that the same default scope is still selected
	       switch( newScope) {
	        case "Document":
	            assertTrue("saved current scope is " + newScope, driver.findElement(By.id("searchType_0") ).isSelected());
	            assertFalse("After save; current scope is not People", driver.findElement(By.id("searchType_1")).isSelected());
	            assertFalse("After save; current scope is not Site content", driver.findElement(By.id("searchType_2")).isSelected());
	            break;
	        case "People":
	            assertTrue("savedvcurrent scope is " + newScope, driver.findElement(By.id("searchType_1") ).isSelected());
	            assertFalse("After save; current scope is not Document", driver.findElement(By.id("searchType_0")).isSelected());
	            assertFalse("After save; current scope is not Site content", driver.findElement(By.id("searchType_2")).isSelected());
	            break;
	        case "Site content":
	            assertTrue("saved current scope is " + newScope, driver.findElement(By.id("searchType_2") ).isSelected());
	            assertFalse("After save; current scope is not People", driver.findElement(By.id("searchType_1")).isSelected());
	            assertFalse("After save; current scope is not Document", driver.findElement(By.id("searchType_0")).isSelected());
	         }
	}
	
	
	@When("^the following employees exist$")
	public void the_following_employees_exist(DataTable dataTable) throws Throwable{
	    
	    expectedResults = dataTable.asList(User.class);
	    System.out.println("in the following employees exist");
	}
	
	@And("^the following search item does not exist$")
	public void the_following_search_item_does_not_exist(String searchItem) throws Throwable{
	    
	    throw new PendingException();
	    
	}
	
	@When("user enters \"([^\"]*)\" in search box")
	public void user_enters_in_search_box(String employeeName) throws Throwable{
	    
	    //WebDriverWait wait = new WebDriverWait(driver, 60); 
	    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("home_search_criteria")));
		driver.findElement(By.id("home_search_criteria")).sendKeys(employeeName);
		
		System.out.println("In user enters into search box");
	    
	}
	
	@And("^user submits search request$")
	public void user_submits_search_request() throws Throwable{
	    
	   // WebDriverWait wait = new WebDriverWait(driver,60);
	    //wait.
	   // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("home-search-button")));
	   // driver.findElement(By.id("home_search_button"));
	    //WebElement webElement = driver.findElement(By.id("home_search_button"));
	    // Boolean isShown = webElement.isDisplayed();
	   // if (isShown){
	   //     System.out.println("This element is displayed");
	   //     System.out.println("this element has tag: " + webElement.getTagName());
	   // }
	    
	    WebElement  webEl = driver.findElement(By.id("home-search-button"));
	    webEl.click();
	    Thread.sleep(2000);
	    results = driver.findElement(By.id("home_tab_people"));
        System.out.println(results.getAttribute("heading"));
	    System.out.println("in submits search request");
		//driver.findElement(By.id("home_search_button")).click();
	    
	}
	
	@Then("^the output should be$")
    public void the_output_should_be(List<User> expectedNames) throws Throwable {
	    
	    int numberResults;
	    String id = "";
        	    
	    results = driver.findElement(By.id("home_tab_people"));
	    numberResults = Integer.parseInt(results.getText().replaceAll("[\\D]","")); // replace all characters besides digits with blank
	    System.out.println("number of results " + results.getText());
	    assertTrue("numbr of results is >= 0", numberResults >= 0);
	    assertEquals("number of expected and actual results is the same", expectedNames.size(), numberResults);
	    
	    //find actual results and compare with expected
	    for (int i=0; i<numberResults; i++) {
	        // create ids of the form row0col0, row0col1 etc. to find first name last name, email 
	        id = "row" + String.valueOf(i) +"col" + String.valueOf(0); 
	        fName = driver.findElement(By.id(id));
	        assertEquals("firstName matches",expectedNames.get(i).getGivenName() , fName.getText() );
	        
	        id = "row" + String.valueOf(i) +"col" + String.valueOf(1);
	        lName = driver.findElement(By.id(id));
	        assertEquals("familyName matches ", expectedNames.get(i).getFamilyName(), lName.getText());
	        
	        id = "row" + String.valueOf(i) +"col" + String.valueOf(2);
	        email = driver.findElement(By.id(id));
	        assertEquals("primaryEmail matches ", expectedNames.get(i).getEmail(), email.getText());
	    }	    
	    
	    for (User employee: expectedNames){
	        System.out.println(employee.getGivenName() + " " + employee.getFamilyName() );
	    }
	    
	    
	}
	
	@Then("^the output should be \"([^\"]*)\"$")
	public void the_output_should_be(String arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    System.out.println("output should be");
	  //  throw new PendingException();
	}
	//@Then("ensure list of employees with last name \"([^\"]*)\" is presented")
	//public void Ensure_list_of_employees_with_last_name_presented(String employeeName) throws Throwable{
		//TODO verify that correct list of employee names is given
	//}
	
	@After()  // this will run after every scenario
	public void cleanUp() {
	    System.out.println("After Scenario --- closing the browser");
		driver.close();
		driver.quit();
		
	}

}
