package myhook;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.TestBase;

public class Hooks extends TestBase {
	
	@Before
	public void setup()
	{
		TestBase.initialization();
	}
	
	@After
	public void teardown()
	{
		TestBase.quitedriver();
	}
	
	@AfterStep(order=1)
	public void addScreenshot(Scenario scenario) {
		
			/*FileInputStream extentreport = new FileInputStream("C:\\Users\\Ashwini Raut\\eclipse-workspace\\com.interviewTest\\src\\test\\resources\\extent.properties");
			extendprop.load(extentreport);
			File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMYYYY_HHmmss");
			String sDate = sdf.format(date);
			File filename = new File(extendprop.getProperty("screenshot.dir")+"image_"+sDate+".png");
			FileHandler.copy(srcfile, filename);
			scenario.attach("data", "image/png", "name");*/
			if(scenario.isFailed())
			{
				final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", "image"); 
			}
			
			
			
		
	}
	

}
