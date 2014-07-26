package com.whitestratus.randstad;

import com.opera.core.systems.OperaDriver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.*;


public class Driver  extends Thread{
    

       private static WebDriver aDriver=null;
       private static long browserStartTime = 0L;
       private static long savedTimecount = 0L;
       public static final long DEFAULT_TIMEOUT_SECONDS = 10;
       private static boolean avoidRecursiveCall=false;
       public static final String BROWSER_PROPERTY_NAME = "selenium2basics.webdriver";
       
       public enum BrowserName{FIREFOX, GOOGLECHROME, OPERA, IE, HTMLUNIT}
       
       public static BrowserName currentDriver;
       
       public static BrowserName useThisDriver = null;
       
       
       public static String PROXY="localhost:8080";
       
       public static void set(BrowserName aBrowser) {
           useThisDriver = aBrowser;
           
           //close any existing driver
           if(aDriver != null){
               aDriver.quit();
               aDriver = null;
           }
       }
       
       public static WebDriver get() {
           if(useThisDriver == null)  {
               String defaultBrowser = System.getProperty(BROWSER_PROPERTY_NAME, "FIREFOX");
               switch(defaultBrowser){
                   case "FIREFOX":  
                       useThisDriver = BrowserName.FIREFOX;
                       break;
                   case "CHROME":
                       useThisDriver = BrowserName.GOOGLECHROME;
                       break;
                   case "IE":
                    //   useThisDriver = BrowserName.IE;
                       break;
                   case "OPERA":
                       useThisDriver = BrowserName.OPERA;
                       break;
                   case "HTMLUNIT":
                       useThisDriver = BrowserName.HTMLUNIT;
                       break;
                   default:
                       throw new RuntimeException("Unknown Browser in " + BROWSER_PROPERTY_NAME + ": " + defaultBrowser);
        
               }
               
           }
           
           if(aDriver == null){
               long startBrowserTime = System.currentTimeMillis();
               
               switch(useThisDriver) {
               case FIREFOX:
                   FirefoxProfile profile = new FirefoxProfile();
                   profile.setEnableNativeEvents(true);
                   
                   aDriver = new FirefoxDriver(); 
                   currentDriver = BrowserName.FIREFOX;
                   break;
               case OPERA:
                   aDriver = new OperaDriver();
                   currentDriver = BrowserName.OPERA;
                   break;
               case HTMLUNIT:
                   aDriver = new HtmlUnitDriver();
                   currentDriver = BrowserName.HTMLUNIT;
                   break;
               case IE:
               //    setDriverPropertyIfNecessary("webdriver.ie.driver", "/../tools/iedriver_64/IEDriverServer.exe", "C://webdrivers/iedriver_64/IEDriverServer.exe");
               //    aDriver = new InternetExplorerDriver();
               //    currentDriver = BrowserName.IE;
                   break;
               case GOOGLECHROME:
                   ChromeOptions options = new ChromeOptions();
                   options.addArguments("disable-pligins");
                   options.addArguments("disable-extensions");
                   
                   aDriver = new ChromeDriver(options);
                   currentDriver = BrowserName.GOOGLECHROME;
                   break;
                
                   
               }
               
               long browserStartedTime = System.currentTimeMillis();
               browserStartTime = browserStartedTime - startBrowserTime;
               
               //we want to shutdown the shared browser when the tests finish
               Runtime.getRuntime().addShutdownHook(
                       new Thread(){
                           public void run(){
                               Driver.quit();
                           }
                       }
               );
           } else {
               try {
                   //is browser still alive
                   if(aDriver.getWindowHandle()!=null) {
                       //assume it's still alive
                   }
               }catch(Exception e){
                   if(avoidRecursiveCall){
                       //something has gone wrong as we have been here already
                       throw new RuntimeException();
                   }
                   quit();
                   aDriver=null;
                   avoidRecursiveCall = true;
                   return get();
               }
               savedTimecount += browserStartTime;
               System.out.println("Save another "+ browserStartTime + "ms : total saved " + savedTimecount + "ms");
               
           }
           avoidRecursiveCall = false;
           return aDriver;
       }
       
       public static WebDriver get(String aURL, boolean maximize){
           get();
           aDriver.get(aURL);
           if(maximize){
               try{
                   aDriver.manage().window().maximize();
               }catch(UnsupportedCommandException e){
                   System.out.println("Remote Driver does not support maximise");
               }catch(UnsupportedOperationException e){
                   System.out.println("Opera driver does not support maximize yet");
               }
           }
           return aDriver;
       }
       
       public static WebDriver get(String aURL){
           return get(aURL,true);
       }
       
       public static void quit(){
           if(aDriver!=null){
               System.out.println("total time saved by reusing browsers " + savedTimecount + "ms");
               try{
                   aDriver.quit();
                   aDriver=null;
               }catch(Exception e){
                   // I don't care about errors at this point
               }

           }
       }
       
       
       
}
