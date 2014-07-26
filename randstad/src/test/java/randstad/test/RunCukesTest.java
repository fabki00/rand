package randstad.test;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import org.junit.BeforeClass;
import org.junit.AfterClass;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:target/cucumber-htmlreport", "json:target/cucumber-report.json"},
                // features ={"src/test/resources/randstad/test/MySearch.feature"},
                 //features ={"src/test/resources/randstad/test/PeopleSearch.feature"},  
                features ={"src/test/resources/randstad/test/TmpSearch.feature"},
               // tags = {"@us-68000184-001,@us-68000184-002,@us-68000184-003,@us-68000184-004, @us-68000184-005 " }
                tags ={ "@us-68000184-007"}
                 //tags = {"@us-013-001,@us-013-002"}
                 )

public class RunCukesTest {
	
	// these will run only before features specified in paths or tags in CucumberOptions
	//@BeforeClass
	//public static void setUp() {
	//	System.out.println("Ran Before Class");
		
	//}
	
	//@AfterClass
	//public static void teardown() {
	//	System.out.println("Ran After Class");
	//}
}
 