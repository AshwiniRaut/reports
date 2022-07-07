package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Properties extendprop;
	
	public TestBase()
	{
		try
		{
			prop = new Properties();
			FileInputStream fileinput = new FileInputStream("C:\\Users\\Ashwini Raut\\eclipse-workspace\\com.interviewTest\\src\\test\\resources\\Properties.properties");
			prop.load(fileinput);
		}
		catch(IOException e)
		{
			e.getMessage();
		}
	}
	
	public static void initialization()
	{
		String browsername = prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ashwini Raut\\eclipse-workspace\\com.interviewTest\\src\\test\\resources\\data\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtility.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtility.IMPLICIT_TIMEOUT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	public static void quitedriver()
	{
		driver.close();
	}

}
