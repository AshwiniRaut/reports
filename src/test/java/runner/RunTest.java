package runner;



import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/main/java/features",
		   //path of step definition file
		   glue = {"stepdef","myhook"},
		   plugin = {"pretty", "junit:target/JUNITReports/report.xml", "html:target/HTMLReports", "json:target/JSONReports/report.json",
				   "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		   
				   
		monochrome =true,
		publish = true,
		dryRun = false
		
		   )
public class RunTest {
	
	
	


}
