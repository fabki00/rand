package com.whitestratus.randstad;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class filterApplied {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    //baseUrl = "https://ws-service-endpoints.appspot.com/";
    baseUrl = "https://stratusphere-uat.appspot.com/";
    
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testFilterApplied() throws Exception {
    driver.get(baseUrl + "/ws-ui-app/index.html#/home");
    driver.findElement(By.cssSelector("#dropSitemap > span.caret")).click();
    driver.findElement(By.cssSelector("#dropSitemap > span.caret")).click();
    driver.findElement(By.linkText("People")).click();
    driver.findElement(By.cssSelector("button.ws-search-submit.primary-action-color")).click();
    driver.findElement(By.xpath("(//input[@name='false'])[2]")).clear();
    driver.findElement(By.xpath("(//input[@name='false'])[2]")).sendKeys("Admin");
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
